package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @GetMapping(value = "/login")
    public String Login() 
    {
        user = userRepository.findByIsActiveTrue();
        if(user != null)
        {

            return "redirect:/profile";
        }
        else
        {
            return "Login";
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("emails") String emails, @RequestParam("parole") String password, RedirectAttributes redirectAttributes) {
        user = userRepository.findByEmails(emails);

        if (user != null && user.getPassword().equals(password))
        {
            user.isActive = true;
            userRepository.save(user);
            return "redirect:/profile";
        }
        else
        {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }

    @GetMapping(value = "/forgotpassword")
    public String forgotpassword()
    {
        return "forgotpassword";
    }
}