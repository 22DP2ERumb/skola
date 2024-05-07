package com.example.skola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopStudents {
    @Autowired
    GradesRepository gradesRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/topStudents")
    public String topStudents(Model model)
    {
        List<Grades> bestScienceGrades = gradesRepository.findAllByOrderByScienceAverageDesc();
        for (int i = 0; i < 3 && i < bestScienceGrades.size(); i++) {
            User user = userRepository.findByEmails(bestScienceGrades.get(i).studentEmail);

            model.addAttribute("fullName"+ (i + 1), user.getFullName());
            model.addAttribute("group"+ (i + 1), user.getSchoolClass());
            model.addAttribute("grade" + (i + 1), bestScienceGrades.get(i).scienceAverage);
        }

        List<Grades> bestMathGrades = gradesRepository.findAllByOrderByMathematicsGradeAverageDesc();
        for (int i = 0; i < 3 && i < bestMathGrades.size(); i++) {
            User user = userRepository.findByEmails(bestMathGrades.get(i).studentEmail);

            model.addAttribute("mathFullName"+ (i + 1), user.getFullName());
            model.addAttribute("mathGroup"+ (i + 1), user.getSchoolClass());
            model.addAttribute("mathGrade" + (i + 1), bestMathGrades.get(i).mathematicsGradeAverage);
        }

        List<Grades> bestHistoryGrades = gradesRepository.findAllByOrderByHistoryAverageDesc();
        for (int i = 0; i < 3 && i < bestHistoryGrades.size(); i++) {
            User user = userRepository.findByEmails(bestHistoryGrades.get(i).studentEmail);

            model.addAttribute("historyFullName"+ (i + 1), user.getFullName());
            model.addAttribute("historyGroup"+ (i + 1), user.getSchoolClass());
            model.addAttribute("historyGrade" + (i + 1), bestHistoryGrades.get(i).historyAverage);
        }

        List<Grades> bestEnglishGrades = gradesRepository.findAllByOrderByEnglishAverageDesc();
        for (int i = 0; i < 3 && i < bestEnglishGrades.size(); i++) {
            User user = userRepository.findByEmails(bestEnglishGrades.get(i).studentEmail);

            model.addAttribute("englishFullName"+ (i + 1), user.getFullName());
            model.addAttribute("englishGroup"+ (i + 1), user.getSchoolClass());
            model.addAttribute("englishGrade" + (i + 1), bestEnglishGrades.get(i).englishAverage);
        }

        List<Grades> bestSportGrades = gradesRepository.findAllByOrderBySportAverageDesc();
        for (int i = 0; i < 3 && i < bestSportGrades.size(); i++) {
            User user = userRepository.findByEmails(bestSportGrades.get(i).studentEmail);

            model.addAttribute("sportFullName"+ (i + 1), user.getFullName());
            model.addAttribute("sportGroup"+ (i + 1), user.getSchoolClass());
            model.addAttribute("sportGrade" + (i + 1), bestSportGrades.get(i).sportAverage);
        }

        List<Grades> bestComputerGrades = gradesRepository.findAllByOrderByComputerScienceAverageDesc();
        for (int i = 0; i < 3 && i < bestComputerGrades.size(); i++) {
            User user = userRepository.findByEmails(bestComputerGrades.get(i).studentEmail);

            model.addAttribute("computerFullName"+ (i + 1), user.getFullName());
            model.addAttribute("computerGroup"+ (i + 1), user.getSchoolClass());
            model.addAttribute("computerGrade" + (i + 1), bestComputerGrades.get(i).computerScienceAverage);
        }

        return "topStudents.html";
    }
}
