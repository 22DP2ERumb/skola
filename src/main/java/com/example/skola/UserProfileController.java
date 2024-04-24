package com.example.skola;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.ToString;

@Controller
public class UserProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    private GradesRepository gradesRepository;


    private User user;
    

    @GetMapping(value = "/profile")
    public String UsersProfile(Model model) {
        user = userRepository.findByIsActiveTrue();
        if(user != null)
        {
            model.addAttribute("fullName", user.getFullName());
            model.addAttribute("username", user.getSchoolClass());
            model.addAttribute("Email", user.getEmails());
            model.addAttribute("numurs", user.getNumurs());
            model.addAttribute("role", user.getLore());
            return "UsersProfile";
        }
        else
        {
            return "redirect:/login";
        }
    }
    @GetMapping("/logout")
    public String logout() 
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            user.isActive = false;
            userRepository.save(user);
            return "redirect:/";
        }
        else
        {
            return "redirect:/login";
        }
    }

    @GetMapping("/grades")
    public String grades(Model model,  @RequestParam(value = "Group", defaultValue = "DP1-1") String schoolGroup)
    {

        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            model.addAttribute("role", user.getLore());
            if (user.getLore().equals("Teacher"))
            {
                model.addAttribute("subject", user.getSubject());
                model.addAttribute("group", schoolGroup);

                List<User> userList = userRepository.findByLoreAndSchoolClass("Student", schoolGroup);
                
                for (int i = 0; i < userList.size(); i++) {
                    model.addAttribute("FullName" + (i + 1), userList.get(i).getFullName());
                    model.addAttribute("Email" + (i + 1), userList.get(i).getEmails()); // Need request from client witch group.

                    String UserEmail = userList.get(i).getEmails();
                    Grades grades = gradesRepository.findByStudentEmail(UserEmail);


                    if (grades != null)
                    {
                        if(user.getSubject().equals("Mathematics"))
                        {
                            model.addAttribute("Grade1" + (i + 1), grades.mathematicsGrade1);
                            model.addAttribute("Grade2" + (i + 1), grades.mathematicsGrade2);
                            model.addAttribute("Grade3" + (i + 1), grades.mathematicsGrade3);
                            model.addAttribute("Grade4" + (i + 1), grades.mathematicsGrade4);
                            model.addAttribute("Grade5" + (i + 1), grades.mathematicsGrade5);
                            double average = Functions.CalculateAverage(grades.mathematicsGrade1, grades.mathematicsGrade2, grades.mathematicsGrade3, grades.mathematicsGrade4, grades.mathematicsGrade5);
                            model.addAttribute("Average" + (i + 1), average);
                        }
                    }
                }
                return "GradeStudent";
            }
            else if (user.getLore().equals("Student"))
            {
                String UserEmail = user.getEmails();
                Grades grades = gradesRepository.findByStudentEmail(UserEmail);
                model.addAttribute("Science1", grades.scienceGrade1);
                model.addAttribute("Science2", grades.scienceGrade2);
                model.addAttribute("Science3", grades.scienceGrade3);
                model.addAttribute("Science4", grades.scienceGrade4);
                model.addAttribute("Science5", grades.scienceGrade5);

                double Scienceaverage = Functions.CalculateAverage(grades.scienceGrade1, grades.scienceGrade2, grades.scienceGrade3, grades.scienceGrade4, grades.scienceGrade5);
                model.addAttribute("ScienceAverage", Scienceaverage);


                model.addAttribute("Math1", grades.mathematicsGrade1);
                model.addAttribute("Math2", grades.mathematicsGrade2);
                model.addAttribute("Math3", grades.mathematicsGrade3);
                model.addAttribute("Math4", grades.mathematicsGrade4);
                model.addAttribute("Math5", grades.mathematicsGrade5);

                double MathAverage = Functions.CalculateAverage(grades.mathematicsGrade1, grades.mathematicsGrade2, grades.mathematicsGrade3, grades.mathematicsGrade4, grades.mathematicsGrade5);
                model.addAttribute("MathAverage", MathAverage);

                model.addAttribute("History1", grades.historyGrade1);
                model.addAttribute("History2", grades.historyGrade2);
                model.addAttribute("History3", grades.historyGrade3);
                model.addAttribute("History4", grades.historyGrade4);
                model.addAttribute("History5", grades.historyGrade5);

                double HistoryAverage = Functions.CalculateAverage(grades.historyGrade1, grades.historyGrade2, grades.historyGrade3, grades.historyGrade4, grades.historyGrade5);
                model.addAttribute("HistoryAverage", HistoryAverage);

                model.addAttribute("English1", grades.englishGrade1);
                model.addAttribute("English2", grades.englishGrade2);
                model.addAttribute("English3", grades.englishGrade3);
                model.addAttribute("English4", grades.englishGrade4);
                model.addAttribute("English5", grades.englishGrade5);

                double EnglishAverage = Functions.CalculateAverage(grades.englishGrade1, grades.englishGrade2, grades.englishGrade3, grades.englishGrade4, grades.englishGrade5);
                model.addAttribute("EnglishAverage", EnglishAverage);
                
                model.addAttribute("Sport1", grades.sportGrade1);
                model.addAttribute("Sport2", grades.sportGrade2);
                model.addAttribute("Sport3", grades.sportGrade3);
                model.addAttribute("Sport4", grades.sportGrade4);
                model.addAttribute("Sport5", grades.sportGrade5);

                double SportAverage = Functions.CalculateAverage(grades.sportGrade1, grades.sportGrade2, grades.sportGrade3, grades.sportGrade4, grades.sportGrade5);
                model.addAttribute("SportAverage", SportAverage);

                model.addAttribute("Computer1", grades.computerScienceGrade1);
                model.addAttribute("Computer2", grades.computerScienceGrade2);
                model.addAttribute("Computer3", grades.computerScienceGrade3);
                model.addAttribute("Computer4", grades.computerScienceGrade4);
                model.addAttribute("Computer5", grades.computerScienceGrade5);

                double ComputerAverage = Functions.CalculateAverage(grades.computerScienceGrade1, grades.computerScienceGrade2, grades.computerScienceGrade3, grades.computerScienceGrade4, grades.computerScienceGrade5);
                model.addAttribute("ComputerAverage", ComputerAverage);
                

            }
            return "Grades";
        }
        else
        {
            return "redirect:/login";
        }
    }

    @PostMapping("/grades")
    public String grades(@RequestParam Map<String, String> allParams)
    {
        user = userRepository.findByIsActiveTrue();
        List<User> userList = userRepository.findByLoreAndSchoolClass("Student", allParams.get("group"));

        for (int i = 0; i < userList.size(); i++) 
        {
            if(user.getSubject().equals("Mathematics"))
            {
                String studentEmail = allParams.get("Email" + (i + 1));
                Grades studentGrades = gradesRepository.findByStudentEmail(studentEmail);

                String grade1 = allParams.get("Grade1" + (i + 1));
                String grade2 = allParams.get("Grade2" + (i + 1));
                String grade3 = allParams.get("Grade3" + (i + 1));
                String grade4 = allParams.get("Grade4" + (i + 1));
                String grade5 = allParams.get("Grade5" + (i + 1));

                if (grade1 != null){studentGrades.mathematicsGrade1 = Integer.parseInt(grade1);}
                if (grade2 != null){studentGrades.mathematicsGrade1 = Integer.parseInt(grade2);}
                if (grade3 != null){studentGrades.mathematicsGrade1 = Integer.parseInt(grade3);}
                if (grade4 != null){studentGrades.mathematicsGrade1 = Integer.parseInt(grade4);}
                if (grade5 != null){studentGrades.mathematicsGrade1 = Integer.parseInt(grade5);}



                gradesRepository.save(studentGrades);


            }
            
        }

        // System.err.println(allParams.get("group"));
        // List<User> userList = userRepository.findByLoreAndSchoolClass("Student", schoolGroup);
                
        // for (int i = 0; i < userList.size(); i++) {
            
        // }
        return "redirect:/grades";
    }

    @GetMapping("/lessons")
    public String lessons(Model model, @RequestParam(value = "day", defaultValue = "Monday") String day)
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            String grupa = user.getSchoolClass();

            Lessons lessons = lessonsRepository.findBySchoolClassAndSchoolDay(grupa, day);
            model.addAttribute("day", day); 
            model.addAttribute("role", user.getLore());
            if (lessons != null)
            {
                model.addAttribute("Subject1", lessons.lesson1);
                model.addAttribute("Subject2", lessons.lesson2);
                model.addAttribute("Subject3", lessons.lesson3);
                model.addAttribute("Subject4", lessons.lesson4);
                model.addAttribute("Subject5", lessons.lesson5);
                model.addAttribute("Subject6", lessons.lesson6);
                model.addAttribute("Subject7", lessons.lesson7);
                model.addAttribute("Subject8", lessons.lesson8);
                model.addAttribute("Subject9", lessons.lesson9);
                model.addAttribute("Subject10", lessons.lesson10);
                model.addAttribute("Subject11", lessons.lesson11);
                model.addAttribute("Subject12", lessons.lesson12);
 
            }

            return "Lessons";
        }
        else
        {
            return "redirect:/login";
        }
    }
    @GetMapping("/support")
    public String support(Model model)
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            model.addAttribute("role", user.getLore());
            return "support";
        }
        else
        {
            return "redirect:/login";
        }
    }
    @GetMapping("/lessonManager")
    public String lessonManager()
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null && "MacibuDala".equals(user.getLore()))
        {
            return "StunduSarakstaVeidosana";
        }
        else
        {
            return "redirect:/login";
        }
    }

    @PostMapping ("/lessonManager")
    public String lessonManager(@RequestParam("lesson1") String lesson1, @RequestParam("lesson2") String lesson2, @RequestParam("lesson3") String lesson3, @RequestParam("lesson4") String lesson4, @RequestParam("lesson5") String lesson5, @RequestParam("lesson6") String lesson6, @RequestParam("lesson7") String lesson7, @RequestParam("lesson8") String lesson8, @RequestParam("lesson9") String lesson9, @RequestParam("lesson10") String lesson10, @RequestParam("lesson11") String lesson11, @RequestParam("lesson12") String lesson12, @RequestParam("schoolClass") String schoolClass, @RequestParam("schoolDay") String schoolDay)
    {
        Lessons lessons = lessonsRepository.findBySchoolClassAndSchoolDay(schoolClass, schoolDay);
        if (lessons == null)
        {
            Lessons lesson = new Lessons(lesson1, lesson2, lesson3, lesson4, lesson5, lesson6, lesson7, lesson8, lesson9, lesson10, lesson11, lesson12, schoolClass, schoolDay);
            lessonsRepository.save(lesson);
        }
        else
        {
            lessons.lesson1 = lesson1;
            lessons.lesson2 = lesson2;
            lessons.lesson3 = lesson3;
            lessons.lesson4 = lesson4;
            lessons.lesson5 = lesson5;
            lessons.lesson6 = lesson6;
            lessons.lesson7 = lesson7;
            lessons.lesson8 = lesson8;
            lessons.lesson9 = lesson9;
            lessons.lesson10 = lesson10;
            lessons.lesson11 = lesson11;
            lessons.lesson12 = lesson12;
            lessonsRepository.save(lessons);
        }
        return "redirect:/lessonManager";
    }
}
