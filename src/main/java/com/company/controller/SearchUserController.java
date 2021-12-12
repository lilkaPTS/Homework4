package com.company.controller;

import com.company.model.SearchMessage;
import com.company.model.SearchUser;
import com.company.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SearchUserController {
    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("searchUser", new SearchUser());
        return "search";
    }

    @GetMapping("/search")
    public String getSearchResultForm(Model model, @ModelAttribute SearchUser searchUser, @ModelAttribute SearchMessage searchMessage, HttpServletRequest request, HttpServletResponse response) throws IOException {
        searchMessage.setMessage(searchUser, request);
        model.addAttribute("foundUser", User.searchUser(searchUser));
        return "searchResult";
    }
}
