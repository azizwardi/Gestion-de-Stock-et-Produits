package tn.esprit.gestion_de_stock_et_produits.usermicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class Usermod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String resetToken;
    private LocalDateTime resetTokenExpiry;

    // Constructor without resetToken and resetTokenExpiry
    public Usermod(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Constructor with all fields
    public Usermod(Long id, String username, String email, String password, String resetToken, LocalDateTime resetTokenExpiry) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.resetToken = resetToken;
        this.resetTokenExpiry = resetTokenExpiry;
    }
}