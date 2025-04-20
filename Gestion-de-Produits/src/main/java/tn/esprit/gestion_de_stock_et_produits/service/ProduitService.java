

package tn.esprit.gestion_de_stock_et_produits.service;

import tn.esprit.gestion_de_stock_et_produits.model.Produit;
import tn.esprit.gestion_de_stock_et_produits.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(int id) {
        return produitRepository.findById(id).orElse(null);
    }

    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }



    public void deleteProduit(int id) {
        produitRepository.deleteById(id);
    }

    public List<Produit> getProduitsByCategorie(String categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    public List<Produit> getProduitsByPrixBetween(double prixMin, double prixMax) {
        return produitRepository.findByPrixBetween(prixMin, prixMax);
    }

    public List<Produit> getProduitsByMarque(String marque) {
        return produitRepository.findByMarque(marque);
    }

    public List<Produit> getProduitsEnStock(int quantiteStock) {
        return produitRepository.findByQuantiteStockGreaterThan(quantiteStock); // Modifié ici
    }
}