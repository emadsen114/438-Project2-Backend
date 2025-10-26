#!/bin/bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home
export GOOGLE_CLIENT_ID="${GOOGLE_CLIENT_ID:-965757428397-0qptrjl7r6q4427ur966okjn79erlvde.apps.googleusercontent.com}"
export GOOGLE_CLIENT_SECRET="${GOOGLE_CLIENT_SECRET:-your-secret-here}"

./gradlew bootRun