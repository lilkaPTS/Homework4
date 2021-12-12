package com.company.controller;

import com.company.email.EmailSender;
import com.company.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @ResponseBody
    @RequestMapping("/sentEmail")
    public String sendSimpleEmail(@ModelAttribute User user) {
        EmailSender.sentEmail("lilgud@mail.ru", "Ilya", "Alexeyevich");
        return "Email Sent!";
    }
}
