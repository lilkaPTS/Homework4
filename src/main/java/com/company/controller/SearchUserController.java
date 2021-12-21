package com.company.controller;

import com.company.model.SearchMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SearchUserController {
    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        //model.addAttribute("searchUser", new SearchUser());
        return "search";
    }

    @GetMapping("/search")
    public String getSearchResultForm(Model model, @ModelAttribute SearchMessage searchMessage, HttpServletRequest request, HttpServletResponse response) {
        //searchMessage.setMessage(searchUser, request);
        //model.addAttribute("foundUser", User.search(searchUser));
        return "searchResult";
    }
}
