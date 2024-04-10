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
    private int lessonNumber;
    private String subject;
    private String school_day;
    private String schoolclass;

    public Lessons() {
    }

    public Lessons(int lessonNumber, String subject, String schoolclass, String school_day)
    {
        this.lessonNumber = lessonNumber;
        this.subject = subject;
        this.school_day = school_day;
        this.schoolclass = schoolclass;
    }
    
}