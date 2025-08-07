# testeLeandro

🚀 **Test Java Application with CI/CD Pipeline**

A comprehensive Java application demonstrating modern DevOps practices with GitHub Actions CI/CD pipeline.

## 📋 Project Overview

This is a test repository showcasing:
- **Java 17** application with Maven build system
- **Comprehensive test suite** with JUnit 5
- **GitHub Actions CI/CD pipeline** with multi-stage build
- **Docker containerization** with multi-stage builds
- **Security scanning** and code quality analysis
- **Automated artifact management**

## 🏗️ Project Structure

```
testeLeandro/
├── .github/
│   └── workflows/
│       └── java-ci.yml          # GitHub Actions CI/CD pipeline
├── src/
│   ├── main/java/com/leandro/teste/
│   │   └── App.java             # Main application class
│   └── test/java/com/leandro/teste/
│       └── AppTest.java         # Comprehensive test suite
├── pom.xml                      # Maven configuration
├── Dockerfile                   # Multi-stage Docker build
├── mvnw                         # Maven wrapper script
└── .gitignore                   # Git ignore rules
```

## 🚀 Features

### Application Features
- **Personalized greeting system** with validation
- **Mathematical operations** (addition, even/odd detection)
- **Comprehensive error handling**
- **Clean, documented code**

### DevOps Features
- **Multi-version Java support** (Java 11, 17, 21)
- **Maven dependency caching** for faster builds
- **Automated testing** with detailed reports
- **Code coverage analysis** with JaCoCo
- **Static code analysis** with SpotBugs
- **Security scanning** with OWASP Dependency Check
- **Docker image building** and publishing to GitHub Container Registry
- **Artifact management** with build outputs

## 🔧 GitHub Actions Workflow

The project includes a comprehensive CI/CD pipeline that:

### Build Stage
- ✅ **Multi-version testing** on Java 11, 17, and 21
- ✅ **Dependency caching** for optimized build times
- ✅ **Automated testing** with JUnit 5
- ✅ **Code coverage** reporting with JaCoCo
- ✅ **Static analysis** with SpotBugs
- ✅ **Test report generation** with detailed results
- ✅ **Build artifact upload** for each Java version

### Security Stage
- 🔒 **OWASP Dependency scanning** for vulnerabilities
- 🔒 **Security report generation** and artifact upload
- 🔒 **Automated security analysis** on every build

### Docker Stage (Main branch only)
- 🐳 **Multi-stage Docker builds** for optimized images
- 🐳 **GitHub Container Registry publishing**
- 🐳 **Image tagging** with latest and commit SHA
- 🐳 **Build caching** for faster subsequent builds

### Workflow File Content

Create `.github/workflows/java-ci.yml`:

\`\`\`yaml
name: Java CI/CD Pipeline

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    
    strategy:
      matrix:
        java-version: [11, 17, 21]
    
    steps:
    - name: Checkout code
      uses: actions/checkout@v4
      
    - name: Set up JDK \${{ matrix.java-version }}
      uses: actions/setup-java@v4
      with:
        java-version: \${{ matrix.java-version }}
        distribution: 'temurin'
        
    - name: Cache Maven dependencies
      uses: actions/cache@v4
      with:
        path: ~/.m2
        key: \${{ runner.os }}-m2-\${{ hashFiles('**/pom.xml') }}
        restore-keys: \${{ runner.os }}-m2
        
    - name: Run tests
      run: mvn clean test
      
    - name: Build application
      run: mvn clean compile package -DskipTests
      
    - name: Run static code analysis with SpotBugs
      run: mvn spotbugs:check
      continue-on-error: true
      
    - name: Generate test report
      uses: dorny/test-reporter@v1
      if: success() || failure()
      with:
        name: Maven Tests
        path: target/surefire-reports/*.xml
        reporter: java-junit
        
    - name: Upload build artifacts
      uses: actions/upload-artifact@v4
      with:
        name: jar-artifacts-java-\${{ matrix.java-version }}
        path: target/*.jar
        
    - name: Upload coverage reports to Codecov
      uses: codecov/codecov-action@v4
      if: matrix.java-version == '17'
      with:
        file: target/site/jacoco/jacoco.xml
        
  security-scan:
    runs-on: ubuntu-latest
    needs: build
    
    steps:
    - name: Checkout code
      uses: actions/checkout@v4
      
    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        
    - name: Cache Maven dependencies
      uses: actions/cache@v4
      with:
        path: ~/.m2
        key: \${{ runner.os }}-m2-\${{ hashFiles('**/pom.xml') }}
        restore-keys: \${{ runner.os }}-m2
        
    - name: Run OWASP Dependency Check
      run: mvn org.owasp:dependency-check-maven:check
      continue-on-error: true
      
    - name: Upload security scan results
      uses: actions/upload-artifact@v4
      if: always()
      with:
        name: security-scan-results
        path: target/dependency-check-report.html

  docker-build:
    runs-on: ubuntu-latest
    needs: build
    if: github.event_name == 'push' && github.ref == 'refs/heads/main'
    
    steps:
    - name: Checkout code
      uses: actions/checkout@v4
      
    - name: Set up Docker Buildx
      uses: docker/setup-buildx-action@v3
      
    - name: Login to GitHub Container Registry
      uses: docker/login-action@v3
      with:
        registry: ghcr.io
        username: \${{ github.actor }}
        password: \${{ secrets.GITHUB_TOKEN }}
        
    - name: Build and push Docker image
      uses: docker/build-push-action@v5
      with:
        context: .
        push: true
        tags: |
          ghcr.io/\${{ github.repository }}:latest
          ghcr.io/\${{ github.repository }}:\${{ github.sha }}
        cache-from: type=gha
        cache-to: type=gha,mode=max
\`\`\`

## 🛠️ Local Development

### Prerequisites
- Java 17+ installed
- Maven 3.6+ (or use included wrapper)

### Building the Project
\`\`\`bash
# Using Maven wrapper (recommended)
./mvnw clean compile

# Or using system Maven
mvn clean compile
\`\`\`

### Running Tests
\`\`\`bash
# Run all tests
./mvnw clean test

# Run with coverage report
./mvnw clean test jacoco:report
\`\`\`

### Running the Application
\`\`\`bash
# Compile and run
./mvnw clean compile exec:java -Dexec.mainClass="com.leandro.teste.App"
\`\`\`

### Docker Build
\`\`\`bash
# Build Docker image
docker build -t testeLeandro .

# Run Docker container
docker run testeLeandro
\`\`\`

## 📊 Test Coverage

The project includes comprehensive test coverage for:
- ✅ **Greeting functionality** with various input scenarios
- ✅ **Mathematical operations** with edge cases
- ✅ **Error handling** and input validation
- ✅ **Boundary testing** for all methods

## 🔒 Security Features

- **OWASP Dependency Check** for vulnerability scanning
- **Multi-stage Docker builds** for smaller, more secure images
- **Non-root user** in Docker containers
- **Security artifact reporting**

## 📈 Code Quality

- **SpotBugs** static analysis
- **JaCoCo** code coverage reporting
- **JUnit 5** modern testing framework
- **Clean code principles** with comprehensive documentation

## 🚀 CI/CD Pipeline Triggers

- **Push to main/develop**: Full pipeline with Docker build and deployment
- **Pull Request**: Build and test validation
- **Manual dispatch**: Available for manual triggering

## 📝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Ensure tests pass
5. Submit a pull request

---

**Created by:** Leandro (DevOps Evangelist)  
**Repository:** https://github.com/leandrofrs/testeLeandro