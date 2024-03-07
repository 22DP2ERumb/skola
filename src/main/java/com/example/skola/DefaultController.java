package com.example.skola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DefaultController {
    
    @RequestMapping(value = "/")
    public String index() {
        return "MainPage.html";
    }
}