package com.company.controller;

import com.company.service.EmailService;
import com.company.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/searchResult")
    public String getSendResult(@ModelAttribute User foundUser){
        emailService.sentEmail(foundUser);
        return "sendResult";
    }

}
