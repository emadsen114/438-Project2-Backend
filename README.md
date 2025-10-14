# 438-Project2-Backend
<!-- 
make sure your in cd demo

./gradlew clean bootJar

docker build --no-cache \
  --build-arg JAR_FILE='build/libs/demo-0.0.1-SNAPSHOT.jar' \
  -t springboot-demo:local .

docker run --rm -p 8080:8080 springboot-demo:local


curl http://localhost:8080/
curl http://localhost:8080/greeting



set heroku app name:
export APP=alberto-demo-1760040975
heroku apps:info -a "$APP"


Make sure Spring Boot binds to Heroku’s dynamic port:

demo/src/main/resources/application.properties
server.port=${PORT:8080}

deploy from demo folder:
cd 438-Project2-Backend/demo

heroku container:login
heroku container:push web -a "$APP"
heroku container:release web -a "$APP"

heroku logs --tail -a "$APP"

open live app

heroku open -a "$APP"


after rebooting:

cd 438-Project2-Backend/demo

restore heroku app variable:
export project2-438-backend

heroku login
heroku container:login

REDEPLOY IF CODE CHANGED:
heroku container:push web -a "$APP"
heroku container:release web -a "$APP"


heroku logs --tail -a "$APP"
heroku open -a "$APP"



EXAMPLE:

cd demo
export project2-438-backend
heroku login
heroku container:login
heroku container:push web -a "$APP"
heroku container:release web -a "$APP"
heroku open -a "$APP"




Tips & Troubleshooting
Run from the correct folder: All Docker/Heroku commands must run inside demo/.
If you see H10 App crashed:
Check logs → heroku logs --tail -a "$APP"
Make sure your app binds to $PORT (not 8080).
Memory issues (exit code 137):
heroku config:set JAVA_OPTS="-XX:MaxRAMPercentage=75.0" -a "$APP"
Empty $APP variable?
export APP=alberto-demo-1760040975
or just include -a alberto-demo-1760040975 in your commands.
🧠 Helpful Commands Reference
Task	Command
Build locally	./gradlew clean bootJar
Build & run Docker	docker build ... && docker run ...
Deploy to Heroku	heroku container:push web -a "$APP"
Release on Heroku	heroku container:release web -a "$APP"
View logs	heroku logs --tail -a "$APP"
Open app	heroku open -a "$APP"

->

