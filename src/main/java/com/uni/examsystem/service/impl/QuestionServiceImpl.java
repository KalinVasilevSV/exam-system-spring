package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.entities.AnswerSetEntity;
import com.uni.examsystem.models.entities.QuestionEntity;
import com.uni.examsystem.models.entities.enums.AnswerEnum;
import com.uni.examsystem.models.entities.enums.QuestionTypeEnum;
import com.uni.examsystem.models.view.QuestionView;
import com.uni.examsystem.repositories.AnswerSetRepository;
import com.uni.examsystem.repositories.QuestionRepository;
import com.uni.examsystem.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerSetRepository answerSetRepository;

    private final ModelMapper modelMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerSetRepository answerSetRepository,ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.answerSetRepository=answerSetRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<QuestionView> findById(Long id) {
        return questionRepository.findById(id)
                .map(questionEntity -> modelMapper.map(questionEntity, QuestionView.class));

    }


    @Override
    public void initializeQuestions() {
        if(questionRepository.count()==0){
            QuestionEntity question1= new QuestionEntity();
            question1.setQuestion("Two six sided dice are thrown together. What is the probability that a total of 10 is thrown?");
            question1.setqType(QuestionTypeEnum.CLOSED);
            question1.setScore(3.0F);
            AnswerSetEntity answerSet1=new AnswerSetEntity();
            answerSet1.setA("1/6");
            answerSet1.setB("1/12");
            answerSet1.setC("1/2");
            answerSet1.setAnswer(AnswerEnum.A);
            question1.setAnswerSet(answerSet1);
            answerSetRepository.save(answerSet1);
            questionRepository.save(question1);

            QuestionEntity question2=new QuestionEntity();
            question2.setQuestion("What is the speed in m/s of a car that travels 30km in 20 minutes?");
            question2.setqType(QuestionTypeEnum.OPEN);
            question2.setScore(10.0F);
            questionRepository.save(question2);
        }
    }
}
