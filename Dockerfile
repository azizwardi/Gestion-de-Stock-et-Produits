FROM openjdk:17

EXPOSE 8761

ADD target/Gestion_de_Stock_et_Produits-0.0.1-SNAPSHOT.jar Stock.jar

ENTRYPOINT ["java", "-jar", "Stock.jar"]
