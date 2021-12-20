package com.uni.examsystem.web;

import com.uni.examsystem.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/all")
    public String allExams(Model model) {
        model.addAttribute("exams",examService.getAll().get());
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
    public String editExam(@PathVariable Long id) {
        return "edit-exam";
    }
}
