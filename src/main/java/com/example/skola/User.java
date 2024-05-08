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

    private String password;
    private String Fullname;
    private String emails;
    private String numurs;
    private String lore;
    private String subject;
    public boolean isActive;
    public String schoolClass;

    public User() {
    }

    public User(String parole, String Fullname, String emails, String numurs, String schoolClass)
    {
        password = parole;
        this.Fullname = Fullname;
        this.emails = emails;
        this.numurs = numurs;
        isActive = false;
        lore = "";
        subject = null;
        this.schoolClass = schoolClass;
    }
    
    public String getPassword() {
        return password;
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

    public String getLore()
    {
        return lore;
    }
    public String getSchoolClass()
    {
        return schoolClass;
    }
    public String getSubject()
    {
        return subject;
    }
    public void SetLore(String lore) {
        this.lore = lore;
    }

    public void SetSubject(String subject)
    {
        this.subject = subject;
    }

    public void SetFullName(String fullname)
    {
        Fullname = fullname;
    }

    public void SetNumber(String number)
    {
        numurs = number;
    }

    public void SetPassword(String password)
    {
        this.password = password;
    }
}
