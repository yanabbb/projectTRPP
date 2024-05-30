FROM openjdk:17

WORKDIR /app

COPY . /app

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/build/libs/project-0.0.1-SNAPSHOT.jar"]