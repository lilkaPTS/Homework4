package com.company.controller;

import com.company.service.AppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppendUsersFromFileController {

    @Autowired
    private AppendService appendService;

    @GetMapping("/appendForm")
    public String getAppendUsersFromFile() {
        return "append";
    }

    @PostMapping("/append")
    public String registrationSubmit(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(fileName);
        return "appendResult";
    }
}
