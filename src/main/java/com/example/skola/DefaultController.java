package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DefaultController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(value = "/")
    public String Home() {
        return "MainPage.html";
    }

    @GetMapping(value = "/login")
    public String Login() {

        
        // User user = new User("John", "123");

        return "Login.html";
    }

}

