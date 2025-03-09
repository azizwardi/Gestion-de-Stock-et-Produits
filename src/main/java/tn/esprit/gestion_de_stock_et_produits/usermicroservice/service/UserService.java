package tn.esprit.gestion_de_stock_et_produits.usermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.DTO.LoginDTO;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.DTO.UserDTO;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.Repository.UserRepository;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.entity.Usermod;
import tn.esprit.gestion_de_stock_et_produits.usermicroservice.payload.LoginMessage;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        Usermod user = new Usermod(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepository.save(user);
        return user.getUsername();
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        Usermod user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Usermod> userOptional = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (userOptional.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exists", false);
        }
    }
}