package com.example.skola;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sk_Lessons")
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String lesson1;
    String lesson2;
    String lesson3;
    String lesson4;
    String lesson5;
    String lesson6;
    String lesson7;
    String lesson8;
    String lesson9;
    String lesson10;
    String lesson11;
    String lesson12;

    private String schoolClass;
    String schoolDay;
    

    public Lessons() {
    }

    public Lessons(String lesson1, String lesson2, String lesson3, String lesson4, String lesson5, String lesson6, String lesson7, String lesson8, String lesson9, String lesson10, String lesson11, String lesson12, String schoolClass, String schoolDay)
    {
        this.lesson1 = lesson1;
        this.lesson2 = lesson2;
        this.lesson3 = lesson3;
        this.lesson4 = lesson4;
        this.lesson5 = lesson5;
        this.lesson6 = lesson6;
        this.lesson7 = lesson7;
        this.lesson8 = lesson8;
        this.lesson9 = lesson9;
        this.lesson10 = lesson10;
        this.lesson11 = lesson11;
        this.lesson12 = lesson12;

        this.schoolClass = schoolClass;
        this.schoolDay = schoolDay;
    }
    
}