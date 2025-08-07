# 🚀 GitHub Actions Workflow Setup Instructions

## 📋 Current Status
✅ **Workflow files have been created in the repository root**
⚠️ **Manual setup required to activate GitHub Actions**

## 🔧 Required Setup Steps

### Step 1: Move Workflow Files to Correct Location

The GitHub Actions workflows need to be in the `.github/workflows/` directory to be automatically detected and executed.

**Files to move:**
- `java-ci-cd-pipeline.yml` → `.github/workflows/java-ci-cd-pipeline.yml`
- `ci.yml` → `.github/workflows/ci.yml` (optional, simple version)

### Step 2: Manual Repository Setup

1. **Navigate to your repository:** https://github.com/leandrofrs/testeLeandro

2. **Create the workflows directory:**
   - Click "Create new file"
   - Type: `.github/workflows/java-ci.yml`
   - Copy the content from `java-ci-cd-pipeline.yml`
   - Commit the file

3. **Clean up root directory (optional):**
   - Delete `java-ci-cd-pipeline.yml` from root
   - Delete `ci.yml` from root
   - Delete this instructions file

### Step 3: Verify Workflow Activation

1. **Check the Actions tab:** https://github.com/leandrofrs/testeLeandro/actions
2. **Make a test commit** to trigger the workflow
3. **Monitor the build progress** in the Actions tab

## 🎯 Workflow Features

### **Build Stage** (Multi-Java Version Testing)
- ✅ **Java 11, 17, 21** compatibility testing
- ✅ **Maven dependency caching** for faster builds
- ✅ **Automated testing** with comprehensive reports
- ✅ **Static code analysis** with SpotBugs
- ✅ **Build artifact management**
- ✅ **Code coverage** reporting with JaCoCo

### **Security Stage**
- 🔒 **OWASP dependency scanning** for vulnerabilities
- 🔒 **Security report generation** and artifact storage
- 🔒 **Automated vulnerability assessment**

### **Docker Stage** (Main Branch Only)
- 🐳 **Multi-stage Docker builds** for optimized images
- 🐳 **GitHub Container Registry** publishing
- 🐳 **Automatic image tagging** (latest + commit SHA)
- 🐳 **Build caching** for performance optimization

## 🚀 Workflow Triggers

The pipeline will automatically run on:
- **Push to `main` or `develop` branches**
- **Pull requests targeting `main`**
- **Manual workflow dispatch** (via GitHub UI)

## 🔧 Local Testing Commands

Before pushing, you can test locally:

```bash
# Run tests
./mvnw clean test

# Build application
./mvnw clean package

# Run security scan
./mvnw org.owasp:dependency-check-maven:check

# Build Docker image
docker build -t testeLeandro .
```

## 📊 Expected Workflow Results

Once activated, each workflow run will:
1. **Build and test** across multiple Java versions
2. **Generate test reports** with detailed results
3. **Upload build artifacts** for download
4. **Perform security scanning** with vulnerability reports
5. **Create Docker images** (on main branch pushes)
6. **Publish containers** to GitHub Container Registry

## ❗ Important Notes

- **Container Registry:** Ensure your repository has Container Registry enabled
- **Permissions:** The workflow uses `GITHUB_TOKEN` with default permissions
- **Branch Protection:** Consider enabling branch protection rules for `main`
- **Secrets:** No additional secrets required for basic functionality

## 🎯 Next Steps

1. Move workflow file to `.github/workflows/`
2. Make a test commit to trigger the workflow
3. Monitor the Actions tab for execution results
4. Review and customize the workflow as needed

---

**Repository:** https://github.com/leandrofrs/testeLeandro  
**Actions:** https://github.com/leandrofrs/testeLeandro/actions