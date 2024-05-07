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

    double mathematicsGradeAverage;

    int scienceGrade1;
    int scienceGrade2;
    int scienceGrade3;
    int scienceGrade4;
    int scienceGrade5;

    double scienceAverage;

    int historyGrade1;
    int historyGrade2;
    int historyGrade3;
    int historyGrade4;
    int historyGrade5;

    double historyAverage;

    int englishGrade1;
    int englishGrade2;
    int englishGrade3;
    int englishGrade4;
    int englishGrade5;

    double englishAverage;
    
    int sportGrade1;
    int sportGrade2;
    int sportGrade3;
    int sportGrade4;
    int sportGrade5;

    double sportAverage;

    int computerScienceGrade1;
    int computerScienceGrade2;
    int computerScienceGrade3;
    int computerScienceGrade4;
    int computerScienceGrade5;

    double computerScienceAverage;

    public Grades(String studentEmail) {

        this.studentEmail = studentEmail;
        
        this.mathematicsGrade1 = -1;
        this.mathematicsGrade2 = -1;
        this.mathematicsGrade3 = -1;
        this.mathematicsGrade4 = -1;
        this.mathematicsGrade5 = -1;
    
        this.scienceGrade1 = -1;
        this.scienceGrade2 = -1;
        this.scienceGrade3 = -1;
        this.scienceGrade4 = -1;
        this.scienceGrade5 = -1;
    
        this.historyGrade1 = -1;
        this.historyGrade2 = -1;
        this.historyGrade3 = -1;
        this.historyGrade4 = -1;
        this.historyGrade5 = -1;
    
        this.englishGrade1 = -1;
        this.englishGrade2 = -1;
        this.englishGrade3 = -1;
        this.englishGrade4 = -1;
        this.englishGrade5 = -1;
        
        this.sportGrade1 = -1;
        this.sportGrade2 = -1;
        this.sportGrade3 = -1;
        this.sportGrade4 = -1;
        this.sportGrade5 = -1;
    
        this.computerScienceGrade1 = -1;
        this.computerScienceGrade2 = -1;
        this.computerScienceGrade3 = -1;
        this.computerScienceGrade4 = -1;
        this.computerScienceGrade5 = -1;

        this.mathematicsGradeAverage = 0;
        this.scienceAverage = 0;
        this.historyAverage = 0;
        this.englishAverage = 0;
        this.sportAverage = 0;
        this.computerScienceAverage = 0;
    }
    
    public Grades()
    {

    }
}
