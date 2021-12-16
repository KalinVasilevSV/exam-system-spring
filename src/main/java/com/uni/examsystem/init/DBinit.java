package com.uni.examsystem.init;

import com.uni.examsystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinit implements CommandLineRunner {

    private final UserService userService;

    public DBinit(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) {
        userService.initializeUsersAndRoles();
    }
}
