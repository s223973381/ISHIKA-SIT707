FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/sit707-7.2h-gcp-cicd-java-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]