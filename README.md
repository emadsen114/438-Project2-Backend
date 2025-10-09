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



->