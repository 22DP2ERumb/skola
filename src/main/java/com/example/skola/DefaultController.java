package com.example.skola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DefaultController {
    
    @RequestMapping(value = "/")
    public String Home() {
        return "MainPage.html";
    }

    @RequestMapping(value = "/Login")
    public String Login() {
        return "Login.html";
    }

}