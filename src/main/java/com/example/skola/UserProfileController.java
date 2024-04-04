package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserProfileController {
    @Autowired
    private UserRepository userRepository;

    private User user;

    @GetMapping(value = "/profile")
    public String UsersProfile(Model model) {
        user = userRepository.findByIsActiveTrue();
        if(user != null)
        {
            model.addAttribute("fullName", user.getFullName());
            model.addAttribute("username", user.getUsername());
            model.addAttribute("Email", user.getEmails());
            model.addAttribute("numurs", user.getNumurs());
            return "UsersProfile";
        }
        else
        {
            return "redirect:/login";
        }
    }
    @PostMapping("/logout")
    public String logout() 
    {
        if (user != null) {
            user.isActive = false;
            userRepository.save(user);
        }
        return "redirect:/login";
    } 
}
