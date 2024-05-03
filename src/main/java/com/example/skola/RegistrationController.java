package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GradesRepository gradesRepository;
    
    @GetMapping(value = "/registration")
    public String Regsitration()
    {
        return "Registration.html";
    }

    @PostMapping ("/registration")
    public String Registration(@RequestParam("schoolClass") String schoolClass, @RequestParam("parole") String password, @RequestParam("pilnsvards") String Fullname, @RequestParam("emails") String emails, @RequestParam("numurs") String numurs, @RequestParam("apstripinatparole") String repeatPassword)
    {
        User check = userRepository.findByEmails(emails);
        if(check == null && password.matches(repeatPassword))
        {
            User user = new User(password, Fullname, emails, numurs, schoolClass);

            userRepository.save(user);
            return "redirect:/login";
        }
        else
        {
            return "redirect:/registration";
        }
        
    }
        
}
