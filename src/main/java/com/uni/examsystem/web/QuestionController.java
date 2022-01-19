package com.uni.examsystem.web;

import com.uni.examsystem.models.binding.QuestionBindingModel;
import com.uni.examsystem.service.QuestionService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public QuestionController(QuestionService questionService, ModelMapper modelMapper) {
        this.questionService = questionService;
        this.modelMapper = modelMapper;
    }


    @ModelAttribute("questionModel")
    public QuestionBindingModel registerQuestionBindingModel(){return new QuestionBindingModel();}

    @GetMapping("/add")
    public String addQuestion() {
        return "add-question";
    }

    @PostMapping("/add")
    public String saveQuestion(@Valid QuestionBindingModel questionModel, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("question_error",true);
            redirectAttributes.addFlashAttribute("questionModel",questionModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.questionModel",bindingResult);
            return "redirect:/questions/add";
        }
        questionService.saveQuestion(questionModel);
        return "redirect:/questions/panel";
    }

    @GetMapping("/{id}/details")
    public String questionDetails(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionService.findById(id).get());

        return "question-details";
    }

    @GetMapping("/{id}/edit")
    public String editQuestion(@PathVariable Long id, Model model) {

        var questionView = questionService.findById(id);
        var questionUpdateBindingModel = modelMapper.map(questionView, QuestionBindingModel.class);


        model.addAttribute("questionModel", questionUpdateBindingModel);
        model.addAttribute("questionView", questionView);

        return "edit-question";
    }

    @PatchMapping("/{id}/edit")
    public String editQuestion(@PathVariable Long id, @Valid QuestionBindingModel questionModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("questionModel", questionModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.questionModel", bindingResult);
            return "redirect:/questions/" + id + "/edit";
        }
        questionService.updateQuestion(questionModel);

        return "redirect:/questions/" + id + "/details";
    }

    @GetMapping("/panel")
    public String questionsPanel(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());

        return "questions-panel";
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions/" + (id - 1) + "/details";
    }
}
