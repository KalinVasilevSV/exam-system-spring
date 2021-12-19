package com.uni.examsystem.service.impl;

import com.uni.examsystem.repositories.ExamRepository;
import com.uni.examsystem.service.ExamService;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository){
        this.examRepository = examRepository;
    }

    @Override
    public boolean isExamNameFree(String examname) {
        return examRepository.findByExamName(examname).isEmpty();
    }
}
