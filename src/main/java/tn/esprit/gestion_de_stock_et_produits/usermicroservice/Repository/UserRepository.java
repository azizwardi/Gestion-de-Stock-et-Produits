package tn.esprit.gestion_de_stock_et_produits.usermicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.entity.Usermod;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usermod, Long> {
    Optional<Usermod> findOneByEmailAndPassword(String email, String password);
    Usermod findByEmail(String email);
}