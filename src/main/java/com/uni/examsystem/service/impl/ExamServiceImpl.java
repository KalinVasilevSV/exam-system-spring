package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.binding.ExamBindingModel;
import com.uni.examsystem.models.entities.ExamEntity;
import com.uni.examsystem.models.entities.enums.ExamStatusEnum;
import com.uni.examsystem.models.view.ExamView;
import com.uni.examsystem.repositories.ExamRepository;
import com.uni.examsystem.repositories.QuestionRepository;
import com.uni.examsystem.service.ExamService;
import com.uni.examsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;
    private final UserService userService;

    public ExamServiceImpl(ExamRepository examRepository, ModelMapper modelMapper, QuestionRepository questionRepository, UserService userService) {
        this.examRepository = examRepository;
        this.modelMapper = modelMapper;
        this.questionRepository = questionRepository;
        this.userService = userService;
    }

    @Override
    public boolean isExamNameFree(String examName) {
        return examRepository.findByExamName(examName).isEmpty();
    }

    @Override
    public Optional<ExamView> findById(Long id) {

        return examRepository.findById(id).map(examEntity -> modelMapper.map(examEntity, ExamView.class));
    }

    @Override
    public List<ExamView> getAll() {
        return examRepository.findAll()
                .stream()
                .map(examEntity -> modelMapper.map(examEntity, ExamView.class)).collect(Collectors.toList());
    }

    @Override
    public void initializeExams() {

        if (examRepository.count() == 0) {
            ExamEntity exam = new ExamEntity();
            exam.setExamName("Test Exam");
            exam.setQuestions(Set.of(questionRepository.findById(1L).orElseThrow(),
                    questionRepository.findById(2L).orElseThrow()));
            exam.setStatus(ExamStatusEnum.LIVE);
            exam.setUsers(Set.of(userService.findByFacNumber("0123456789").orElseThrow()));
            exam.setTimeGiven(Duration.ofMinutes(40));
            examRepository.save(exam);
        }
    }

    @Override
    public void updateExam(ExamBindingModel examModel) {
        var examEntity = examRepository.findById(examModel.getId()).orElseThrow();

        examEntity.setTimeGiven(examModel.getTimeGiven());
        examEntity.setExamName(examModel.getName());
        examEntity.setStatus(examModel.getStatus());

        examRepository.save(examEntity);

    }
}
