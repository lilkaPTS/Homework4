package com.company.dao;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    @Autowired
    private UserRepository repository;

    public void save(User user){
        repository.save(user);
    }
}
