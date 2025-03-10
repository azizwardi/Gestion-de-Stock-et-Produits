package tn.esprit.gestion_de_stock_et_produits.usermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.service.ForgotPasswordService;

@RestController
@RequestMapping("/auth")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        return forgotPasswordService.sendResetPasswordEmail(email);
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        return forgotPasswordService.resetPassword(token, newPassword);
    }
}
