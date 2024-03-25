package com.example.skola;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping ("/registration")
    public String Registration(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password, RedirectAttributes redirectAttributes)
    {
        User check = userRepository.findByUsername(username);
        if(check == null)
        {
            if(isEmailValid(username))
            {
                if(password.length() > 5 )
                {
                    User user = new User(username, password);
                    userRepository.save(user);               
                    return "redirect:/login";
                }
                else
                {
                    redirectAttributes.addFlashAttribute("error", "Password length should be at least 5 characters");
                    return "redirect:/registration";
                }
            }
            else
            {
                redirectAttributes.addFlashAttribute("error", "Email is not vaild");
                return "redirect:/registration";
            }
        }
        else
        {
            redirectAttributes.addFlashAttribute("error", "Username already exists");
            return "redirect:/registration";
        }        
    }
    private boolean isEmailValid(String email) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailPattern).matcher(email).matches();
    }
}
