package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GestionDeCommandes {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeCommandes.class, args);
    }

}