package com.company.controller;

import com.company.model.User;

import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository repository;

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
    public String registrationSubmit(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "registration";
        }
        repository.save(user);
        return "registrationResults";
    }
}
