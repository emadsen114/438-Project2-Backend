# ---------- build ----------
FROM gradle:8.9.0-jdk21-alpine AS build
WORKDIR /home/gradle/project

# Cache dependencies
COPY build.gradle settings.gradle ./
COPY gradle gradle
RUN gradle --no-daemon dependencies || true

# Build the app
COPY . .
RUN ./gradlew --no-daemon clean bootJar -x test

# ---------- run ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

# Heroku passes PORT dynamically
CMD ["sh", "-lc", "java -jar app.jar --server.port=$PORT"]