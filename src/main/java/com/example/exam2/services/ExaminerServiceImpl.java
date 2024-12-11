package com.example.exam2.services;

import java.util.*;

import com.example.exam2.NotEnoughQuestionsException;
import org.springframework.http.HttpStatus;
import com.example.exam2.models.Question;
import org.springframework.stereotype.Service;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getQuestionCount()) {
            throw new NotEnoughQuestionsException("Not enough questions in the QuestionService", HttpStatus.BAD_REQUEST);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
