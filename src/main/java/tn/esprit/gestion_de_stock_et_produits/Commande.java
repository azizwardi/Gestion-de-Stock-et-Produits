package tn.esprit.gestion_de_stock_et_produits;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity

public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateCommande;

    @Column(nullable = false)
    private String clientId; // Lien vers le microservice Utilisateurs

    @ElementCollection
    private List<Long> produitIds; // Liste des IDs des produits (lien vers microservice Produits)

    @Column(nullable = false)
    private Double montantTotal;

    @Enumerated(EnumType.STRING)
    private StatutCommande statut;

    // Constructeurs
    public Commande() {
    }

    public Commande(LocalDateTime dateCommande, String clientId, List<Long> produitIds, Double montantTotal, StatutCommande statut) {
        this.dateCommande = dateCommande;
        this.clientId = clientId;
        this.produitIds = produitIds;
        this.montantTotal = montantTotal;
        this.statut = statut;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<Long> getProduitIds() {
        return produitIds;
    }

    public void setProduitIds(List<Long> produitIds) {
        this.produitIds = produitIds;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }
}

