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
    @GetMapping("/searchForm") //ссылка по которой нам отдаётся форма регистрации
    public String getSearchForm(Model model) {
        model.addAttribute("searchUser", new SearchUser());
        return "search"; //то, что нам отдаёт ссылка сверху
    }

    @GetMapping("/searchResult") //ссылка по которой нам отдаётся форма регистрации
    public String getSearchResultForm() {
        return "searchResult"; //то, что нам отдаёт ссылка сверху
    }

    /*
    @GetMapping("/searchNot") //ссылка по которой нам отдаётся форма регистрации
    public String getSearchResultForm(@ModelAttribute SearchUser searchUser, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = User.searchUser(searchUser.getFirstName(), searchUser.getLastName());
        model.addAttribute("searchMessage", new SearchMessage());
        if(user == null) {
            model.addAttribute("Пользователь не найден!");
        } else {
            HttpSession session = request.getSession(true);
            String result = "Текущее время: " + new Date(session.getCreationTime()) +
                    " \nИмя браузера: " + request.getHeader("User-Agent") +
                    "\nПользователь: " + user;
            model.addAttribute(result);
        }
        return "searchResult"; //то, что нам отдаёт ссылка сверху
    }

     */
}
