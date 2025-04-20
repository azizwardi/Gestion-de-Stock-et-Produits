package tn.esprit.gestion_de_stock_et_produits.usermicroservice.service;

import tn.esprit.gestion_de_stock_et_produits.usermicroservice.DTO.LoginDTO;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.DTO.UserDTO;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.payload.LoginMessage;

public interface IUserService {
    String addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
}