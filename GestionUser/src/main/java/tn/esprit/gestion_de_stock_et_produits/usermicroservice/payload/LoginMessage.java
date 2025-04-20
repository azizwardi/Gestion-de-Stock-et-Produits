package tn.esprit.gestion_de_stock_et_produits.usermicroservice.payload;

public class LoginMessage {
    private String message;
    private Boolean status;

    public LoginMessage() {
    }

    public LoginMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}