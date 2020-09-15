package com.staxter.userrepository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

/**
 * User Domain Object
 */ 
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String plainTextPassword;
    private String hashedPassword;

    public User(){}

    /* Constructor to set Values */
    public User(String firstName, String lastName, String userName, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.plainTextPassword = password;
       // createHashPassword(password);
    }

/*    private void createHashPassword(String password) {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash);

    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonIgnore
    public String getPlainTextPassword() {
        return plainTextPassword;
    }

    public void setPlainTextPassword(String plainTextPassword) {
        this.plainTextPassword = plainTextPassword;
    }

    @JsonIgnore
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword;
    }
}
