package com.uni.examsystem.service;

import com.uni.examsystem.models.view.ExamView;

import java.util.Optional;
import java.util.Set;

public interface ExamService {
    //TODO
    boolean isExamNameFree(String examname);

    Optional<ExamView> findById(Long id);
    Optional<Set<ExamView>> getAll();
    void initializeExams();
}
