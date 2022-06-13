FROM openjdk:17
WORKDIR /backend
ADD build/libs/individual-track-spring-backend-0.0.1-SNAPSHOT.jar individual-track-spring-backend.jar
COPY /. .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "individual-track-spring-backend.jar"]