#Define base docker image
FROM openjdk:17
LABEL maintainer="spring-docker-image-maintainer"
#copy the jar file to the docker image
ADD build/libs/Individual-Track-Project-0.0.1-SNAPSHOT.jar springboot-docker-image.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-image.jar"]