package com.company.controller;

import com.company.model.User;

import com.company.services.AppendFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegistrationController {

    @Autowired
    public AppendFromFile appendFromFile;

    @GetMapping("/")
    public void getStartPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/registrationForm");
    }

    @GetMapping("/registrationForm")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute User user) {
        User.saveUser(user);
        return "registrationResults";
    }
}
