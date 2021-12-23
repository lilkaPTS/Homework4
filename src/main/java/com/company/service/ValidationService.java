package com.company.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isEmail(String str) {
        return str.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    public boolean isPartName(String str) {
        return str.matches("^[A-Za-z]+$");
    }

    public boolean isAge(String str) {
        if(isInteger(str)) {
            return Integer.parseInt(str) < 110;
        } else {
            return false;
        }
    }

}
