package com.company.controller;

import com.company.dao.UserDAO;
import com.company.model.Message;
import com.company.model.SearchUser;
import com.company.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SearchUserController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserDAO dao;

    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("searchUser", new SearchUser());
        return "search";
    }

    @GetMapping("/search")
    public String getSearchResultForm(Model model, @ModelAttribute SearchUser searchUser, @ModelAttribute Message message, HttpServletRequest request) {
        message.setMessage(messageService.searchMessage(searchUser, request));
        model.addAttribute("foundUser", dao.search(searchUser.getFirstName(), searchUser.getLastName()));
        return "searchResult";
    }
}
