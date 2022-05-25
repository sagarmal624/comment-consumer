FROM openjdk:8
ADD target/comment-consumer-0.0.1-SNAPSHOT.jar  comment-consumer-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","comment-consumer-0.0.1-SNAPSHOT.jar"]