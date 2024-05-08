package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(value = "/registration")
    public String Regsitration()
    {
        return "Registration.html";
    }

    @PostMapping ("/registration")
    public String Registration(@RequestParam("schoolClass") String schoolClass, @RequestParam("parole") String password, @RequestParam("pilnsvards") String Fullname, @RequestParam("emails") String emails, @RequestParam("numurs") String numurs, @RequestParam("apstripinatparole") String repeatPassword, RedirectAttributes redirectAttributes)
    {
        User check = userRepository.findByEmails(emails);
        if(check == null && password.matches(repeatPassword))
        {
            if (numurs.matches("^2[0-9]{7}$"))
            {
                if (Fullname.matches("^[a-zA-ZāčēģīķļņšūžĀČĒĢĪĶĻŅŠŪŽ]+\\s[a-zA-ZāčēģīķļņšūžĀČĒĢĪĶĻŅŠŪŽ]+$"))
                {
                    if (password.matches(".{5,}"))
                    {
                        User user = new User(password, Fullname, emails, numurs, schoolClass);
                        userRepository.save(user);

                        return "redirect:/login";
                    }
                    else
                    {
                        redirectAttributes.addFlashAttribute("error", "Invalid password.");
                        return "redirect:/registration";
                    }

                }
                else
                {
                    redirectAttributes.addFlashAttribute("error", "Invalid full name.");
                    return "redirect:/registration";
                }

            }
            else
            {
                redirectAttributes.addFlashAttribute("error", "Invalid number.");
                return "redirect:/registration";
            }
        }
        else
        {
            redirectAttributes.addFlashAttribute("error", "Password dosent match.");
            return "redirect:/registration";
        }
        
    }
        
}
