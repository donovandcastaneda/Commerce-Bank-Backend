package net.commercebank.cb.entity;

public class AuthenticationResponse {
    private String token;
    private String message;

    private Integer id; // Change to Integer if your User ID is an Integer


    public AuthenticationResponse(String token, String message, Integer id) {
        this.token = token;
        this.message = message;
        this.id = id; // Set the userId in the constructor

    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id; // Getter for userId
    }
}
