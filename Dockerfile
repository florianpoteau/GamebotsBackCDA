FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app
COPY src /app/
COPY pom.xml /app/
COPY .mvn /app/
COPY mvnw /app/
COPY mvnw.cmd /app/
COPY src/main/resources/certs /app/certs

RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean install

FROM openjdk

LABEL app="Gamebots"
LABEL version="0.0.1"
LABEL description="Gamebots est une plateforme où les participants peuvent interagir avec une IA pour lui parler de jeux vidéos."

WORKDIR /app
COPY --from=build /app/target/GamebotsBack-0.0.1-SNAPSHOT.jar /app/app.jar
COPY --from=build /app/src/main/resources/certs /app/certs

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]