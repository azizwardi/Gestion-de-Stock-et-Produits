package tn.esprit.gestion_de_stock_et_produits;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Créer une commande
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Récupérer une commande par ID
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée avec l'ID : " + id));
    }

    // Récupérer toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Mettre à jour une commande
    public Commande updateCommande(Long id, Commande commandeDetails) {
        Commande commande = getCommandeById(id);
        commande.setDateCommande(commandeDetails.getDateCommande());
        commande.setClientId(commandeDetails.getClientId());
        commande.setProduitIds(commandeDetails.getProduitIds());
        commande.setMontantTotal(commandeDetails.getMontantTotal());
        commande.setStatut(commandeDetails.getStatut());
        return commandeRepository.save(commande);
    }

    // Supprimer une commande
    public void deleteCommande(Long id) {
        Commande commande = getCommandeById(id);
        commandeRepository.delete(commande);
    }

    public void generateInvoicePDF(Long commandeId, String filePath) throws Exception {
        Commande commande = getCommandeById(commandeId);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        document.add(new Paragraph("Facture"));
        document.add(new Paragraph("Numéro de commande : " + commande.getId()));
        document.add(new Paragraph("Date : " + commande.getDateCommande()));
        document.add(new Paragraph("Client ID : " + commande.getClientId()));
        document.add(new Paragraph("Produits : " + commande.getProduitIds().toString()));
        document.add(new Paragraph("Montant total : " + commande.getMontantTotal() + " DT"));
        document.add(new Paragraph("Statut : " + commande.getStatut()));

        document.close();
    }

    public String generateTrackingNumber(Long commandeId) {
        Commande commande = getCommandeById(commandeId);

        // Vérifier si la commande est éligible (par exemple, doit être "EN_COURS")
        if (!"VALIDEE".equals(commande.getStatut().name())) {
            throw new IllegalStateException("Le numéro de suivi ne peut être généré que pour une commande en cours");
        }

        // Générer un numéro de suivi unique
        String trackingNumber = "TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Mettre à jour la commande
        commande.setTrackingNumber(trackingNumber);
        commande.setStatut(StatutCommande.EXPEDIEE); // Mise à jour du statut
        commandeRepository.save(commande);

        return trackingNumber;
    }
}
