package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}