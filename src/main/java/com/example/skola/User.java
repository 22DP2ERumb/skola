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
    private String Fullname;
    private String emails;
    private String numurs;
    public boolean isActive;

    public User() {
    }

    public User(String lietotajvards, String parole, String Fullname, String emails, String numurs)
    {
        username = lietotajvards;
        password = parole;
        this.Fullname = Fullname;
        this.emails = emails;
        this.numurs = numurs;
        isActive = false;
    }
    
    public String getPassword() {
        return password;
    }
    public String getUsername()
    {
        return username;
    }
    public String getFullName()
    {
        return Fullname;
    }

    public String getEmails()
    {
        return emails;
    }

    public String getNumurs()
    {
        return numurs;
    }
}
