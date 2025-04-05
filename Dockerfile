FROM openjdk:17
EXPOSE 8085
ADD target/Gestion_de_User-0.0.1-SNAPSHOT.jar Gestion_de_User-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Gestion_de_User-0.0.1-SNAPSHOT.jar"]