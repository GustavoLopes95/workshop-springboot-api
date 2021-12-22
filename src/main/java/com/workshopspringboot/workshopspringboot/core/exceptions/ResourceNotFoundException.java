package com.workshopspringboot.workshopspringboot.core.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not found id: " + id);
    }
}
