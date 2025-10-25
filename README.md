# 438-Project2-Backend

Spring Boot backend for the Project 2 deliverable.

## Build & Run Locally

- `./gradlew clean bootJar`
- `docker build --no-cache -t springboot-demo:local --build-arg JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar .`
- `docker run --rm -p 8080:8080 springboot-demo:local`
- Try the endpoints: `curl http://localhost:8080/` and `curl http://localhost:8080/greeting`

## Deploy to Heroku

1. Set the app name: `export APP=<your-heroku-app>`
2. Login: `heroku login` and `heroku container:login`
3. Build & push: `heroku container:push web -a "$APP"`
4. Release: `heroku container:release web -a "$APP"`
5. Tail logs: `heroku logs --tail -a "$APP"`
6. Open the app: `heroku open -a "$APP"`

`server.port=${PORT:8080}` is already configured in `src/main/resources/application.properties` so the app binds to the dynamic Heroku port.

## Tips

- Run commands from the repository root (no more nested `demo/` directory).
- If the container exits with code 137, try `heroku config:set JAVA_OPTS="-XX:MaxRAMPercentage=75.0" -a "$APP"`.
- Missing `APP` variable? `export APP=<your-heroku-app>` before running commands.
- Need a quick rebuild later? Repeat steps 3–6 under Deploy to Heroku.
