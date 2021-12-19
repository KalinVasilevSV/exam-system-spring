package com.uni.examsystem.web;

import com.uni.examsystem.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/add")
    public String addQuestion() {
        return "add-question";
    }

    @GetMapping("/{id}/details")
    public String questionDetails(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionService.findById(id));

        return "question-details";
    }

    @GetMapping("/{id}/edit")
    public String editQuestion(@PathVariable Long id) {
        return "edit-question";
    }

}
