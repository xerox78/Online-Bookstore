FROM openjdk:21
LABEL maintainer="xerox78"
EXPOSE 8080
ADD target/onlinebookstore-0.0.1-SNAPSHOT.jar onlinebookstore.jar
ENTRYPOINT ["java", "-jar", "/onlinebookstore.jar"]