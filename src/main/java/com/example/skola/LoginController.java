package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class LoginController {
    @PostMapping("/login")
    public String loginUser(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password, HttpServletRequest request) {

        if ("janis".equals(username) || "janis".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", true);
            return ("UsersProfile.html");
        }
        else
        {
            return ("kaukas");
        }
    }
}