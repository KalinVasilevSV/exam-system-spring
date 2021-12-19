package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.view.QuestionView;
import com.uni.examsystem.repositories.QuestionRepository;
import com.uni.examsystem.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<QuestionView> findById(Long id) {
        return questionRepository.findById(id)
                .map(questionEntity -> modelMapper.map(questionEntity, QuestionView.class));

    }
}
