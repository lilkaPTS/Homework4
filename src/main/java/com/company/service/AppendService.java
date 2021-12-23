package com.company.service;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AppendService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ValidationService validationService;

    public String execute(MultipartFile multipartFile) throws IOException {
        String[] usersInString = new String(multipartFile.getBytes(), "UTF-8").split("\n");
        StringBuilder errors = new StringBuilder();
        for (int i = 0; i < usersInString.length; i++) {
            String[] args = usersInString[i].split("-");
            if (args.length == 7 && argsValidate(args)) {
                repository.save(new User(args[0], args[1], args[2], Integer.parseInt(args[3]), Math.abs(Double.parseDouble(args[4])), args[5], args[6]));
            } else {
                errors.append(i).append(") ").append(getError(args)).append("\n");
            }
        }
        return errors.toString();
    }

    private String getError(String[] args) {
        StringBuilder result = new StringBuilder();
        if(args.length !=7) result.append("args.length !=7");
        result.append("First name - ").append(validationService.isPartName(args[0])).append(" ");
        result.append("Last name - ").append(validationService.isPartName(args[1])).append(" ");
        result.append("Patronymic - ").append(validationService.isPartName(args[2])).append(" ");
        result.append("Age - ").append(validationService.isAge(args[3])).append(" ");
        result.append("Salary - ").append(validationService.isDouble(args[4])).append(" ");
        result.append("Email - ").append(validationService.isEmail(args[5])).append(" ");
        return result.toString();
    }

    private boolean argsValidate(String[] args) {
        return  validationService.isPartName(args[0]) &&
                validationService.isPartName(args[1]) &&
                validationService.isPartName(args[2]) &&
                validationService.isAge(args[3])      &&
                validationService.isDouble(args[4])   &&
                validationService.isEmail(args[5]);
    }

}
