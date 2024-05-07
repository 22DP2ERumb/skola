package com.example.skola;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopStudents {

    @GetMapping(value = "/topStudents")
    public String topStudents(Model model)
    {
        
        return "topStudents.html";
    }
}
