FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY target/seguro-api.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
