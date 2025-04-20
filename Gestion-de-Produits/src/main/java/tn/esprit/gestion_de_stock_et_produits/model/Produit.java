package tn.esprit.gestion_de_stock_et_produits.model;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    private String nomProduit;

    private String description;

    private double prix;

    private int quantiteStock;

    private String marque;

    private String categorie;
}
