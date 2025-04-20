
package tn.esprit.gestion_de_stock_et_produits.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.gestion_de_stock_et_produits.model.Produit;
import tn.esprit.gestion_de_stock_et_produits.service.ProduitService;

import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/produits")
public class ControllerProduit {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable int id) {
        return produitService.getProduitById(id);
    }

    @PostMapping("/add-produits")
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }



    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable int id) {
        produitService.deleteProduit(id);
    }

    @GetMapping("/categorie/{categorie}")
    public List<Produit> getProduitsByCategorie(@PathVariable String categorie) {
        return produitService.getProduitsByCategorie(categorie);
    }

    @GetMapping("/prix/{prixMin}/{prixMax}")
    public List<Produit> getProduitsByPrixBetween(@PathVariable double prixMin, @PathVariable double prixMax) {
        return produitService.getProduitsByPrixBetween(prixMin, prixMax);
    }

    @GetMapping("/marque/{marque}")
    public List<Produit> getProduitsByMarque(@PathVariable String marque) {
        return produitService.getProduitsByMarque(marque);
    }


    @GetMapping("/stock/{quantiteStock}")
    public List<Produit> getProduitsEnStock(@PathVariable int quantiteStock) {
        return produitService.getProduitsEnStock(quantiteStock); 
    }
}