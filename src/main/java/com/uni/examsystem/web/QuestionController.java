package com.uni.examsystem.web;

import com.uni.examsystem.models.binding.QuestionBindingModel;
import com.uni.examsystem.models.view.QuestionView;
import com.uni.examsystem.service.QuestionService;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        model.addAttribute("question", questionService.findById(id).get());

        return "question-details";
    }

    @GetMapping("/{id}/edit")
    public String editQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("question",questionService.findById(id).get());

        return "edit-question";
    }

    //TODO implement method
    @PostMapping("/{id}/edit")
    public String saveEditedQuestion(@PathVariable Long id, @Valid QuestionBindingModel editedQuestion,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("editedQuestion",editedQuestion);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.editedQuestion",bindingResult);
            return "redirect:/questions/"+id+"/edit";
        }

        return "/question-details";
    }

    @GetMapping("/panel")
    public String questionsPanel(Model model){
        model.addAttribute("questions",questionService.getAll());

        return "questions-panel";
    }
}
