package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DefaultController {
    @Autowired
    SupportService supportService;

    @GetMapping(value = "/")
    public String Home() {
        return "MainPage.html";
    }

    @GetMapping(value = "/aboutUs")
    public String AboutUs() {
        return "AboutUs.html";
    }

    @GetMapping(value = "/contactUs")
    public String Contact() {
        return "ContactUs.html";
    }

    @PostMapping("/ContactMail")
    public String ContactMail(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("text") String text, @RequestParam("number") String number)
    {
        supportService.ContactUsMail(text, email, number, name);
        return "redirect:/";
    }
}