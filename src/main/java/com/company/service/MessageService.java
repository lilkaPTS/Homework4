package com.company.service;

import com.company.model.SearchUser;
import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class MessageService {

    @Autowired
    private UserRepository repository;

    public String searchMessage(SearchUser searchUser, HttpServletRequest request) {
        User user = repository.getUserByFirstNameAndLastName(searchUser.getFirstName(), searchUser.getLastName());
        StringBuilder result = new StringBuilder();
        if(user == null) {
            result.append("User not found! \n \n ");
        } else {
            HttpSession session = request.getSession(true);
            result.append("Time now: ")
                    .append(new Date(session.getCreationTime()))
                    .append("\nUser-Agent: ")
                    .append(request.getHeader("User-Agent"))
                    .append("\nUser: ").append(user);
        }
        return result.toString();
    }

}
