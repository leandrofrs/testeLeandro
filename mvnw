#!/bin/sh
# Maven Wrapper Script

MAVEN_PROJECTBASEDIR=${MAVEN_BASEDIR:-"$(cd "$(dirname "$0")"; pwd)"}

MAVEN_WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"

if [ ! -f "$MAVEN_WRAPPER_JAR" ]; then
  echo "Maven wrapper jar not found"
  exit 1
fi

exec java -cp "$MAVEN_WRAPPER_JAR" "-Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR" org.apache.maven.wrapper.MavenWrapperMain "$@"