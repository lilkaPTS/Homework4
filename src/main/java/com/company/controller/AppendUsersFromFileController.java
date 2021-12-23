package com.company.controller;

import com.company.model.Message;
import com.company.service.AppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;

@Controller
public class AppendUsersFromFileController {

    @Autowired
    private AppendService appendService;

    @GetMapping("/appendForm")
    public String getAppendUsersFromFile() {
        return "append";
    }

    @PostMapping("/append")
    public String registrationSubmit(@ModelAttribute Message message, @RequestParam("file") MultipartFile multipartFile, RedirectAttributes attributes) throws IOException {
        message.setMessage(appendService.execute(multipartFile));
        return "appendResult";
    }
}
