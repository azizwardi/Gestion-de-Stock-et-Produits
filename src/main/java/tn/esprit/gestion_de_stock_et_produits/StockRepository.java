package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository < Stock , Long> {
}
