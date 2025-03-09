package tn.esprit.gestion_de_stock_et_produits;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@Tag(name = "Commande", description = "API pour gérer les commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Operation(summary = "Créer une nouvelle commande", description = "Ajoute une commande dans la base de données")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commande créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeService.createCommande(commande);
        return new ResponseEntity<>(nouvelleCommande, HttpStatus.CREATED);
    }

    @Operation(summary = "Récupérer toutes les commandes", description = "Retourne la liste de toutes les commandes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des commandes récupérée avec succès")
    })
    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @Operation(summary = "Récupérer une commande par ID", description = "Retourne une commande spécifique par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande trouvée"),
            @ApiResponse(responseCode = "404", description = "Commande non trouvée")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeById(id);
        return new ResponseEntity<>(commande, HttpStatus.OK);
    }

    @Operation(summary = "Mettre à jour une commande", description = "Met à jour les détails d'une commande existante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande non trouvée")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commandeDetails) {
        Commande commandeMiseAJour = commandeService.updateCommande(id, commandeDetails);
        return new ResponseEntity<>(commandeMiseAJour, HttpStatus.OK);
    }

    @Operation(summary = "Supprimer une commande", description = "Supprime une commande par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Commande supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande non trouvée")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Operation(summary = "Générer une facture PDF", description = "Génère un fichier PDF pour une commande spécifique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Facture générée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande non trouvée")
    })
    @GetMapping("/commandes/{id}/invoice")
    public ResponseEntity<String> generateInvoice(@PathVariable Long id) {
        try {
            String filePath = "invoice_" + id + ".pdf";
            commandeService.generateInvoicePDF(id, filePath);
            return new ResponseEntity<>("Facture générée : " + filePath, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la génération : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
