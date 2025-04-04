package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient

@SpringBootApplication
public class GestionDeUser {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeUser.class, args);
    }

}
