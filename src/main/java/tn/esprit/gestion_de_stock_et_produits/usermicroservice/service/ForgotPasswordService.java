package tn.esprit.gestion_de_stock_et_produits.usermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.Repository.UserRepository;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.entity.Usermod;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder; // Hash passwords

    public String sendResetPasswordEmail(String email) {
        Optional<Usermod> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

        if (userOptional.isEmpty()) {
            return "User not found!";
        }

        Usermod user = userOptional.get();
        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        user.setResetTokenExpiry(LocalDateTime.now().plusHours(1));
        userRepository.save(user);

        String resetLink = "http://localhost:8081/auth/reset-password?token=" + token;

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Password Reset Request");
            message.setText("Click the link to reset your password: " + resetLink);
            mailSender.send(message);
            return "Password reset link sent!";
        } catch (Exception e) {
            return "Failed to send reset email. Please try again.";
        }
    }

    public String resetPassword(String token, String newPassword) {
        Optional<Usermod> userOptional = userRepository.findByResetToken(token);

        if (userOptional.isEmpty()) {
            return "Invalid or expired token!";
        }

        Usermod user = userOptional.get();
        if (user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
            return "Token has expired!";
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null); // Clear token after reset
        user.setResetTokenExpiry(null); // Clear expiry time
        userRepository.save(user);

        return "Password has been reset successfully!";
    }
}
