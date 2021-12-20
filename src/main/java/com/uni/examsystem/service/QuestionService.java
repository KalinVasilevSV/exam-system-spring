package com.uni.examsystem.service;

import com.uni.examsystem.models.binding.QuestionBindingModel;
import com.uni.examsystem.models.view.QuestionView;

import java.util.Optional;
import java.util.Set;

public interface QuestionService {
    void initializeQuestions();
    void updateQuestion(QuestionBindingModel editedQuestion);
    Optional<QuestionView> findById(Long id);
    Optional<Set<QuestionView>> getAll();

    void deleteQuestion(Long id);

}
