package tn.esprit.gestion_de_stock_et_produits.Repository;
import tn.esprit.gestion_de_stock_et_produits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    List<Produit> findByCategorie(String categorie);
    List<Produit> findByPrixBetween(double prixMin, double prixMax);
    List<Produit> findByMarque(String marque);
    List<Produit> findByQuantiteStockGreaterThan(int quantiteStock); // Modifié ici
}