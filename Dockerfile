FROM maven:3-openjdk-17 AS build-image
WORKDIR /to-build-app
COPY . .
RUN mvn package -DskipTests
RUN mvn dependency:go-offline
FROM adoptopenjdk:17-jre
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]