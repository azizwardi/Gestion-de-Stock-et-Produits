package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "Bienvenue dans le service de gestion des commandes. Utilisez /commandes/get-all-commandes pour voir toutes les commandes.";
    }
}
