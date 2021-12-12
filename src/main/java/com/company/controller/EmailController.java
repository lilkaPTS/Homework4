package com.company.controller;

import com.company.email.EmailSender;
import com.company.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @PostMapping("/searchResult")
    public String getSendResult(@ModelAttribute User foundUser){
        System.out.println(foundUser);
        EmailSender.sentEmail(foundUser);
        return "sendResult";
    }
}
