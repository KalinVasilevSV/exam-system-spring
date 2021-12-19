package com.uni.examsystem.init;

import com.uni.examsystem.service.QuestionService;
import com.uni.examsystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinit implements CommandLineRunner {

    private final UserService userService;
    private final QuestionService questionService;

    public DBinit(UserService userService,QuestionService questionService) {
        this.userService = userService;
        this.questionService=questionService;
    }


    @Override
    public void run(String... args) {
        userService.initializeUsersAndRoles();
        questionService.initializeQuestions();
    }
}
