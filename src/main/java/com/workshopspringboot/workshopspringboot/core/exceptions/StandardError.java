package com.workshopspringboot.workshopspringboot.core.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class StandardError {

    private HashMap<String, Object> errors;
    private String message;

    public StandardError(HashMap<String, Object> errors, String message) {
        this.errors = errors;
        this.message = message;
    }

    public StandardError(String message) {
        this.message = message;
        this.errors = new HashMap<>();
    }


}
