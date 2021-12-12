package com.company.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SearchMessage {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(SearchUser searchUser, HttpServletRequest request) {
        User user = User.searchUser(searchUser.getFirstName(), searchUser.getLastName());
        if(user == null) {
            this.message = "User not found!\n \n ";
        } else {
            HttpSession session = request.getSession(true);
            this.message = "Time now: " + new Date(session.getCreationTime()) +
                    " \nUser-Agent: " + request.getHeader("User-Agent") +
                    "\nUser: " + user;
        }
    }
}
