# Utilisation de l'image OpenJDK 17
FROM openjdk:17

# Définition du port exposé
# Remplace 8082 par le port utilisé par ton microservice
EXPOSE 8085

# Copie du fichier JAR généré vers le conteneur
COPY target/Gestion_de_User-0.0.1-SNAPSHOT.jar user.jar

# Commande d'exécution
ENTRYPOINT ["java", "-jar", "/user.jar"]
