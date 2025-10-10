# ---------- build ----------
FROM gradle:8.9.0-jdk21-alpine AS build
WORKDIR /home/gradle/project

# Cache deps
COPY build.gradle settings.gradle ./
COPY gradle gradle
RUN gradle --no-daemon dependencies || true

# Build
COPY . .
RUN ./gradlew --no-daemon clean bootJar -x test

# ---------- run ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the bootJar
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

# Let JVM respect container memory
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0"

# IMPORTANT: bind to Heroku’s $PORT
CMD ["sh","-lc","java $JAVA_OPTS -jar app.jar --server.port=$PORT"]
