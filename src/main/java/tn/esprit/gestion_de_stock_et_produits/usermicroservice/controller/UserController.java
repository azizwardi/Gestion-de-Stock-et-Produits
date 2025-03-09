package tn.esprit.gestion_de_stock_et_produits.usermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.DTO.LoginDTO;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.DTO.UserDTO;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.payload.LoginMessage;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}