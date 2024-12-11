package com.example.exam2.services;

import com.example.exam2.models.Question;
import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    void remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

    Question remove(String question);

    Collection<Question> getQuestions();

    int getQuestionCount();
}
