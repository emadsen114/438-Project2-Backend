# 438-Project2-Backend
<!-- 
Docker Notes (Alberto Rodriguez):
1) Make sure to move ot project root (where Dockerfile is) 

    - cd demo

2) Confirm the Dockerfile ENTRYPOINT is valid JSON 
    - tail -n +1 Dockerfile
        _ must end in " ENTRYPOINT ["java","-jar","app.jar"]" 

3) Rebuild a new Docker image (no cache)
    - ./gradlew bootJar

    Build image: 
        - docker build --no-cache --build-arg JAR_FILE='build/libs/demo-0.0.1-SNAPSHOT.jar' -t springboot-demo:clean .

4) Build the new image
    - docker run --rm -p 8080:8080 springboot-demo:clean
    -  check port :)

5) Test From another terminal
    - curl http://localhost:8080/
    - curl http://localhost:8080/greeting



    more notes: Now rebuild from the demo/ folder:
cd /Users/alberto/438-Project2-Backend/demo
./gradlew clean bootJar
docker build --no-cache --build-arg JAR_FILE='build/libs/demo-0.0.1-SNAPSHOT.jar' -t springboot-demo:webonly .
docker run --rm -p 8080:8080 springboot-demo:webonly


    Test (new terminal):
curl http://localhost:8080/
curl http://localhost:8080/spring
curl http://localhost:8080/greeting



Heroku: 
Set the app env var
export APP=alberto-demo-1760040975
heroku apps:info -a "$APP"
2) Make sure Spring binds to Heroku’s port
Do one of these (either is fine):
Option A — app config (recommended)
Create/edit demo/src/main/resources/application.properties:
server.port=${PORT:8080}
Option B — Docker only
Edit demo/Dockerfile so the final line is:
CMD ["sh","-lc","java $JAVA_OPTS -jar app.jar --server.port=$PORT"]
(If you already added one of these earlier, you’re good.)
3) Deploy from the demo/ folder (where your Dockerfile is)
cd 438-Project2-Backend/demo

heroku container:login
heroku container:push web -a "$APP"
heroku container:release web -a "$APP"
heroku logs --tail -a "$APP"
You’re looking for a log like:
Tomcat started on port <some-number> (http)
where <some-number> is not 8080 (it should be the $PORT Heroku assigned). Then:
heroku open -a "$APP"


->