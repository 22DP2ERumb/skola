package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public RedirectView loginUser(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password) {



        if (username.isEmpty() || password.isEmpty()) {
            return new RedirectView("/Login.html");
        } else {
            return new RedirectView("/loggedin.html");
        }
    }
}