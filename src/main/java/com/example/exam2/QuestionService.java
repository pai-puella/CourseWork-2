package com.example.exam2;

import com.example.exam2.Question;
import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    void remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
