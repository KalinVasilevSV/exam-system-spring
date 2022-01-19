package com.uni.examsystem.service;

import com.uni.examsystem.models.binding.QuestionBindingModel;
import com.uni.examsystem.models.view.QuestionView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionService {
    void initializeQuestions();

    void updateQuestion(QuestionBindingModel editedQuestion);

    Optional<QuestionView> findById(Long id);

    void saveQuestion(QuestionBindingModel questionBindingModel);
    void deleteQuestion(Long id);

    List<QuestionView> getAllQuestions();
}
