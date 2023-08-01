FROM adoptopenjdk/openjdk11
EXPOSE 8081
COPY target/Java6_SpringAuthorization_HT1-0.0.1-SNAPSHOT.jar authapp.jar
COPY . src/main/resources/
CMD ["java", "-jar", "authapp.jar"]

