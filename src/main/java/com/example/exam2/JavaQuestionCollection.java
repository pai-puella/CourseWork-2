package com.example.exam2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaQuestionCollection {
    private Set<Question> questions;

    public JavaQuestionCollection() {
        questions = new HashSet<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        Question question1 = new Question("What is Java?", "Java is a programming language.");
        Question question2 = new Question("What is a class?", "A class is a blueprint for creating objects.");
        Question question3 = new Question("What is an interface?", "An interface is a collection of abstract methods.");
        Question question4 = new Question("What is inheritance?", "Inheritance is a mechanism in which one class acquires the properties and behaviors of another class.");
        Question question5 = new Question("What is polymorphism?", "Polymorphism is the ability of an object to take on many forms.");

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }
}

