FROM gradle:8.9.0-jdk21-alpine AS build
WORKDIR /home/gradle/project

COPY . .
RUN ./gradlew clean bootJar -x test --no-daemon

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]