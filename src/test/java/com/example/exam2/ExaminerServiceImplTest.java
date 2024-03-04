package com.example.exam2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getQuestions_ThrowsNotEnoughQuestionsException_WhenAmountGreaterThanQuestionCount() {
        int amount = 10;
        int questionCount = 5;
        when(questionService.getQuestionCount()).thenReturn(questionCount);

        assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(amount));

        verify(questionService, times(1)).getQuestionCount();
        verifyNoMoreInteractions(questionService);
    }

    @Test
    void getQuestions_ReturnsQuestions_WhenAmountLessThanOrEqualToQuestionCount() {
        int amount = 3;
        int questionCount = 5;
        when(questionService.getQuestionCount()).thenReturn(questionCount);
        Set<Question> mockQuestions = createMockQuestions(amount);
        when(questionService.getRandomQuestion()).thenReturn(mockQuestions);

        Collection<Question> result = examinerService.getQuestions(amount);

        assertEquals(amount, result.size());
        assertTrue(result.containsAll(mockQuestions));

        verify(questionService, times(1)).getQuestionCount();
        verify(questionService, times(amount)).getRandomQuestion();
        verifyNoMoreInteractions(questionService);
    }

    private Set<Question> createMockQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        for (int i = 1; i <= amount; i++) {
            questions.add(new Question("Question " + i, "Answer " + i));
        }
        return questions;
    }
}
