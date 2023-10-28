FROM openjdk:8
ADD target/docker-demo.jar docker-demo.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","docker-demo.jar"]