package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.view.ExamView;
import com.uni.examsystem.repositories.ExamRepository;
import com.uni.examsystem.service.ExamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ModelMapper modelMapper;

    public ExamServiceImpl(ExamRepository examRepository, ModelMapper modelMapper) {
        this.examRepository = examRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isExamNameFree(String examName) {
        return examRepository.findByExamName(examName).isEmpty();
    }

    @Override
    public Optional<ExamView> findById(Long id) {

        return examRepository.findById(id).map(examEntity -> modelMapper.map(examEntity, ExamView.class));
    }
}
