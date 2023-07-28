FROM adoptopenjdk/openjdk8:8-jdk-alpine
EXPOSE 8080
COPY target/Java6_SpringAuthorization_HT1-0.0.1-SNAPSHOT.jar authapp.jar
COPY . src/main/resources/
CMD ["java", "-jar", "authapp.jar"]

