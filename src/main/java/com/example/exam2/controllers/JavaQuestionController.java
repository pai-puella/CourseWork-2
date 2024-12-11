package com.example.exam2.controllers;

import com.example.exam2.models.Question;
import com.example.exam2.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    // Метод для добавления вопроса
    @PostMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    // Метод для удаления вопроса
    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question);
    }

    // Метод для получения всех вопросов
    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getQuestions();
    }
}
