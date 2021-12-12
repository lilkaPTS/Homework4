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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class SearchUserController {
    @GetMapping("/searchForm")
    public String getSearchForm(Model model) {
        model.addAttribute("searchUser", new SearchUser());
        return "search";
    }

    @GetMapping("/search") //get потому что это поиск
    public String getSearchResultForm(@ModelAttribute SearchUser searchUser, @ModelAttribute SearchMessage searchMessage, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = User.searchUser(searchUser.getFirstName(), searchUser.getLastName());
        if(user == null) {
            searchMessage.setMessage("Пользователь не найден!\n \n ");
        } else {
            //можно было сделать через Rest контроллер и response.sendRedirect(); Но мне показалось, что так красивее)
            HttpSession session = request.getSession(true);
            String result = "Текущее время: " + new Date(session.getCreationTime()) +
                    " \nБраузер: " + request.getHeader("User-Agent") +
                    "\nПользователь: " + user;
            searchMessage.setMessage(result);
        }
        return "searchResult";
    }
}
