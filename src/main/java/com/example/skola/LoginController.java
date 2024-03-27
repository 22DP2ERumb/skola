package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;


@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @PostMapping("/login")
    public String loginUser(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password, RedirectAttributes redirectAttributes) {
        user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password))
        {
            user.isActive = true;
            userRepository.save(user);
            return ("redirect:/profile");
        }
        else
        {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }

    }
}