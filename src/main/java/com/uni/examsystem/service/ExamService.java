package com.uni.examsystem.service;

import com.uni.examsystem.models.view.ExamView;

import java.util.Optional;

public interface ExamService {
    //TODO
    boolean isExamNameFree(String examname);

    Optional<ExamView> findById(Long id);

    void initializeExams();
}
