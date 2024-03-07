package com.example.skola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @PostMapping("/login")
    @ResponseBody
    public String LoginUser(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password) {
        if(username == "" || password == "")
        {
            return "idots";
        }
        else
        {
            return username + " " + password;
        }


    }
}
