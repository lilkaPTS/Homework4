package com.company.controller;

import com.company.model.SearchMessage;
import com.company.model.SearchUser;
import com.company.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@RestController
public class SearchUserRestController {

    @GetMapping("/search") //название html c submit - ом
    public String searchSubmit(@ModelAttribute SearchUser searchUser, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = User.searchUser(searchUser.getFirstName(), searchUser.getLastName());
        if(user == null) {
            response.sendRedirect("/searchResult");
            return "Пользователь не найден!";
        } else {
            HttpSession session = request.getSession(true);
            String result = "Текущее время: " + new Date(session.getCreationTime()) +
                    " \nИмя браузера: " + request.getHeader("User-Agent") +
                    "\nПользователь: " + user;
            return result;
        }
    }
}
