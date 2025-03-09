package tn.esprit.gestion_de_stock_et_produits;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produit;
    private int quantite;
    private String emplacement;

    // Constructeurs, getters et setters
}

