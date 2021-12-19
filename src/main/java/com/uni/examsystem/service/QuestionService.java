package com.uni.examsystem.service;

import com.uni.examsystem.models.view.QuestionView;

import java.util.Optional;

public interface QuestionService {

    Optional<QuestionView> findById(Long id);
}
