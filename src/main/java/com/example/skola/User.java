package com.example.skola;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sk_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    public boolean isActive;

    public User() {
    }

    public User(String lietotajvards, String parole)
    {
        username = lietotajvards;
        password = parole;
        isActive = false;
    }
    
    public String getPassword() {
        return password;
    }
    public String getUsername()
    {
        return username;
    }
}
