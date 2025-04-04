package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionDeStockEtProduitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeStockEtProduitsApplication.class, args);
    }
}