# syntax=docker/dockerfile:1
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean install

FROM openjdk:22
LABEL app="Gamebots"
LABEL version=0.0.1
LABEL description="Gamebots est une plateforme où les participants peuvent interagir avec une IA pour lui parler de jeux vidéos."
WORKDIR /app
COPY --from=build /app/target/GamebotsBack-0.0.1-SNAPSHOT.jar /app/GamebotsBack-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]