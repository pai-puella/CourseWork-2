package com.example.exam2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {

    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    public void testAddAndGetAll() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        questionService.add(question1);
        questionService.add(question2);

        Collection<Question> allQuestions = questionService.getAll();

        assertTrue(allQuestions.contains(question1));
        assertTrue(allQuestions.contains(question2));
        assertEquals(2, allQuestions.size());
    }

    @Test
    public void testRemove() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        questionService.add(question1);
        questionService.add(question2);

        questionService.remove(question1);

        Collection<Question> allQuestions = questionService.getAll();

        assertFalse(allQuestions.contains(question1));
        assertTrue(allQuestions.contains(question2));
        assertEquals(1, allQuestions.size());
    }

    @Test
    public void testGetRandomQuestion() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        questionService.add(question1);
        questionService.add(question2);

        Set<Question> randomQuestions = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            randomQuestions.add(questionService.getRandomQuestion());
        }

        assertTrue(randomQuestions.contains(question1));
        assertTrue(randomQuestions.contains(question2));
        assertEquals(2, randomQuestions.size());
    }

    @Test
    public void testGetQuestionCount() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        questionService.add(question1);
        questionService.add(question2);

        int questionCount = questionService.getQuestionCount();

        assertEquals(2, questionCount);
    }
}

