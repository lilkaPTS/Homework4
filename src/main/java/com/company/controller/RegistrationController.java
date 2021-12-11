package com.company.controller;

import com.company.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationController {

    @GetMapping("/registrationForm") //ссылка по которой нам отдаётся форма регистрации
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration"; //то, что нам отдаёт ссылка сверху
    }

    @PostMapping("/registration") //название html c submit - ом
    public String registrationSubmit(@ModelAttribute User user, HttpServletResponse resp) {
        return "searchingResults"; //то что нам отдаёт ссылка сверху
    }

}
