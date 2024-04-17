package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonsRepository lessonsRepository;


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
    public String grades(Model model)
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            model.addAttribute("role", user.getLore());
            if (user.getLore().equals("Teacher"))
            {
                model.addAttribute("subject", user.getSubject());
                return "GradeStudent";
            }
            return "Grades";
        }
        else
        {
            return "redirect:/login";
        }
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
