FROM openjdk:17-alpine
EXPOSE 8081
ADD target/Java6_SpringAuthorization_HT1-0.0.1-SNAPSHOT.jar authapp.jar
ADD . src/main/resources/
CMD ["java", "-jar", "authapp.jar"]

