package com.uni.examsystem.service;

import com.uni.examsystem.models.binding.ExamBindingModel;
import com.uni.examsystem.models.view.ExamView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ExamService {
    //TODO
    boolean isExamNameFree(String examname);

    Optional<ExamView> findById(Long id);

    List<ExamView> getAll();

    void initializeExams();

    void updateExam(ExamBindingModel examModel);
}
