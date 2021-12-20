package com.uni.examsystem.web;

import com.uni.examsystem.models.binding.ExamBindingModel;
import com.uni.examsystem.service.ExamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;
    private final ModelMapper modelMapper;

    public ExamController(ExamService examService, ModelMapper modelMapper) {
        this.examService = examService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String allExams(Model model) {
        model.addAttribute("exams", examService.getAll());
        return "all-exams-admin";

    }

    @GetMapping("/{id}/details")
    public String examDetails(@PathVariable Long id, Model model) {
        model.addAttribute("exam", examService.findById(id));
        return "exam-details-for-admin";
    }

    @GetMapping("/{examId}/{userId}/{scorecardId}/score")
    public String scoreBoard(@PathVariable Long examId,
                             @PathVariable Long userId, @PathVariable Long scorecardId) {

        return "exam-user-scorecard-score";
    }

    @GetMapping("/add")
    public String addExam() {
        return "add-exam";
    }

    @GetMapping("/{id}/edit")
    public String editExam(@PathVariable Long id, Model model) {

        var examView = examService.findById(id);
        var examModel = modelMapper.map(examView, ExamBindingModel.class);

        model.addAttribute("examModel", examModel);
        return "edit-exam";
    }

    @PatchMapping("{id}/edit")
    public String editExam(@PathVariable Long id, @Valid ExamBindingModel examModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("examModel", examModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.examModel", bindingResult);

            return "redirect:/exams/" + id + "/edit";
        }

        examService.updateExam(examModel);

        return "redirect:/exams/" + id + "/details";
    }


}
