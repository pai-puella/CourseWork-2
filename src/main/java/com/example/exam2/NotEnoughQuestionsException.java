package com.example.exam2;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotEnoughQuestionsException extends ResponseStatusException {

    public NotEnoughQuestionsException(String reason, HttpStatus status) {
        super(status, reason);
    }
}

