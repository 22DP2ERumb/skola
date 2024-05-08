package com.example.skola;
import java.lang.Math;


public class Functions {

    public static double CalculateAverage(int grade1, int grade2, int grade3, int grade4, int grade5)
    {
        int counter = 0;
        int sum = 0;

        if (grade1 >= 0) {
            counter++;
            sum += grade1;
        }
        if (grade2 >= 0) {
            counter++;
            sum += grade2;
        }
        if (grade3 >= 0) {
            counter++;
            sum += grade3;
        }
        if (grade4 >= 0) {
            counter++;
            sum += grade4;
        }
        if (grade5 >= 0) {
            counter++;
            sum += grade5;
        }

        if (counter != 0) {
            double result = (double) sum / counter;
            return Math.round(result * 10.0) / 10.0;
        } else {
            return 0;
        }
    }
}
