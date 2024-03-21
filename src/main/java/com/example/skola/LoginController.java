package com.example.skola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    boolean isActive;
    @PostMapping("/login")
    public String loginUser(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password) {

        if ("janis".equals(username) || "janis".equals(password)) {
            isActive = true;
            return ("redirect:/profile");
        }
        else
        {
            return ("kaukas");
        }
    }

    @GetMapping(value = "/profile")
    public String UsersProfile() {
        if(isActive)
        {
            return "UsersProfile.html";
        }
        else
        {
            return ("redirect:/login");
        }
    }
}