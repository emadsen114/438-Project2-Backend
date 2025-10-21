# ---------- build ----------
FROM gradle:8.9.0-jdk21-alpine AS build
WORKDIR /home/gradle/project

# Copy Gradle config & wrapper first to leverage caching
COPY build.gradle settings.gradle ./
COPY gradlew gradlew.bat ./
COPY gradle gradle

# Cache dependencies
RUN gradle --no-daemon dependencies || true

# Copy the rest of the app
COPY . .

# Build Spring Boot jar
RUN ./gradlew --no-daemon clean bootJar -x test

# ---------- run ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from the builder image
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

# Tune memory for Heroku dynos
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0"

# Bind to Heroku’s dynamic $PORT
CMD ["sh", "-lc", "java $JAVA_OPTS -jar app.jar --server.port=$PORT"]