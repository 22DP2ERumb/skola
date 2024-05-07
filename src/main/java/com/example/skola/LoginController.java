package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Autowired
    private GradesRepository gradesRepository;

    

    private boolean UserSelcetRole;

    @GetMapping(value = "/login")
    public String Login() 
    {
        user = userRepository.findByIsActiveTrue();
        if(user != null)
        {
            return "redirect:/profile";
        }
        else
        {
            return "Login";
        }
    }
    @GetMapping(value = "/role")
    public String Role()
    {
        if (UserSelcetRole)
        {
            UserSelcetRole = false;
            return "Role.html";
        }
        else
        {
            return "redirect:/";
        }
    }
    @PostMapping(value = "/role")
    public String RoleSubmit(@RequestParam("role") String role, @RequestParam(value = "subject", defaultValue = "") String subject)
    {
        user.SetLore(role);
        user.SetSubject(subject);

        userRepository.save(user);
        user.isActive = true;
        userRepository.save(user);
        
        if(gradesRepository.findByStudentEmail(user.getEmails()) == null && user.getLore().equals("Student"))
        {
            Grades grades = new Grades(user.getEmails());
            gradesRepository.save(grades);
        }

        
        return "redirect:/profile";

    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("emails") String emails, @RequestParam("parole") String password, RedirectAttributes redirectAttributes) {
        user = userRepository.findByEmails(emails);

        if (user != null && user.getPassword().equals(password))
        {
            if (user.getLore().isEmpty())
            {
                UserSelcetRole = true;
                return "redirect:/role";
            }
            else
            {
                user.isActive = true; // this user
                userRepository.save(user);
                return "redirect:/profile";
            }
        }
        else
        {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }

    @GetMapping(value = "/forgotpassword")
    public String forgotpassword()
    {
        return "forgotpassword";
    }
}