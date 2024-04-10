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
    public String grades()
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            return "Grades";
        }
        else
        {
            return "redirect:/login";
        }
    }
    @GetMapping("/lessons")
    public String lessons(Model model)
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
            // String grupa = user.getSchoolClass();

            // String Subject1 = lessonsRepository.findByLessonNumberAndSchoolclass(1, grupa);

            // model.addAttribute("Subject1", Subject1 );
            // model.addAttribute("Subject2", Subject2);
            // model.addAttribute("Subject3", Subject3);
            // model.addAttribute("Subject4", Subject4);
            // model.addAttribute("Subject5", Subject5);
            // model.addAttribute("Subject6", Subject6);
            // model.addAttribute("Subject7", Subject7);
            // model.addAttribute("Subject8", Subject8);
            // model.addAttribute("Subject9", Subject9);
            // model.addAttribute("Subject10", Subject10);
            // model.addAttribute("Subject11", Subject11);
            // model.addAttribute("Subject12", Subject12);
            return "Lessons";
        }
        else
        {
            return "redirect:/login";
        }
    }
    @GetMapping("/support")
    public String support()
    {
        user = userRepository.findByIsActiveTrue();
        if (user != null)
        {
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
    public String lessonManager(@RequestParam("LessonNumber") int LessonNumber, @RequestParam("Subject") String Subject, @RequestParam("schoolclass") String schoolclass, @RequestParam("Day") String Day )
    {
        Lessons lessons = new Lessons(LessonNumber, Subject, schoolclass, Day);
        lessonsRepository.save(lessons);
        return "redirect:/lessonManager";
    }
}
