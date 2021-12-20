package com.uni.examsystem.init;

import com.uni.examsystem.service.ExamService;
import com.uni.examsystem.service.QuestionService;
import com.uni.examsystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinit implements CommandLineRunner {

    private final UserService userService;
    private final QuestionService questionService;
    private final ExamService examService;

    public DBinit(UserService userService, QuestionService questionService, ExamService examService) {
        this.userService = userService;
        this.questionService=questionService;
        this.examService = examService;
    }


    @Override
    public void run(String... args) {
        userService.initializeUsersAndRoles();
        questionService.initializeQuestions();
        examService.initializeExams();
    }
}
