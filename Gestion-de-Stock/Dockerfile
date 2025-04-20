# Utilisation de l'image OpenJDK 17
FROM openjdk:17

# Définition du port exposé
# Remplace 8082 par le port utilisé par ton microservice
EXPOSE 8088

# Copie du fichier JAR généré vers le conteneur
COPY target/Gestion_de_Stock-0.0.1-SNAPSHOT.jar app.jar

# Commande d'exécution
ENTRYPOINT ["java", "-jar", "/app.jar"]
