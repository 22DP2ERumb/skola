package com.example.skola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DefaultController {
   
    @GetMapping(value = "/")
    public String Home() {
        return "MainPage.html";
    }

    @GetMapping(value = "/login")
    public String Login() {
        return "Login.html";
    }

    @GetMapping(value = "/registration")
    public String Regsitration()
    {
        return "Registration.html";
    }
    
    @GetMapping(value = "/aboutUs")
    public String AboutUs() {
        return "AboutUs.html";
    }

    @GetMapping(value = "/contactUs")
    public String Contact() {
        return "ContactUs.html";
    }
}