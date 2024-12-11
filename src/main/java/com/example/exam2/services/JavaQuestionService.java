package com.example.exam2.services;

import com.example.exam2.models.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    private Collection<Question> questions1 = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        for (Question existingQuestion : questions) {
            if (existingQuestion.getQuestion().equals(question.getQuestion())
                    && existingQuestion.getAnswer().equals(question.getAnswer())) {
                return existingQuestion; // или можно выбросить исключение
            }
        }
        questions.add(question);
        return question;
    }

    @Override
    public void remove(Question question) {
        questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(questions.size());
        return (Question) questions.toArray()[index];
    }

    @Override
    public Question remove(String question) {
        if (question == null || question.isEmpty()) {
            throw new IllegalArgumentException("Question cannot be null or empty");
        }

        for (Question q : questions1) {
            if (q.getQuestion().equals(question)) {
                questions1.remove(q);
                return q;
            }
        }
        throw new IllegalArgumentException("Question not found");
    }

    @Override
    public Collection<Question> getQuestions() {
        return new ArrayList<>(questions1);
    }

    @Override
    public int getQuestionCount() {
        return questions.size();
    }

}

