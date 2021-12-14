package com.company.services;

import com.company.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class AppendFromFile {

    @Bean
    public AppendFromFile getAppendFromFile() throws FileNotFoundException {
        File file = new File("file.txt");
        Scanner in = new Scanner(file);
        while (true) {
            if(in.hasNextLine()) {
                String[] args = in.nextLine().split(" ");
                if(args.length == 7) {
                    User user = new User(args[0], args[1], args[2],
                            Integer.parseInt(args[3]), Double.parseDouble(args[4]), args[5], args[6]);
                    if(!User.contains(user)) {
                        User.saveUser(user);
                    }
                }
            } else {
                break;
            }
        }
        return new AppendFromFile();
    }
}
