package com.example.skola;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sk_grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String studentEmail;

    int mathematicsGrade1;
    int mathematicsGrade2;
    int mathematicsGrade3;
    int mathematicsGrade4;
    int mathematicsGrade5;

    int scienceGrade1;
    int scienceGrade2;
    int scienceGrade3;
    int scienceGrade4;
    int scienceGrade5;

    int historyGrade1;
    int historyGrade2;
    int historyGrade3;
    int historyGrade4;
    int historyGrade5;

    int englishGrade1;
    int englishGrade2;
    int englishGrade3;
    int englishGrade4;
    int englishGrade5;
    
    int sportGrade1;
    int sportGrade2;
    int sportGrade3;
    int sportGrade4;
    int sportGrade5;

    int computerScienceGrade1;
    int computerScienceGrade2;
    int computerScienceGrade3;
    int computerScienceGrade4;
    int computerScienceGrade5;

    public Grades() 
    {

    }
}
