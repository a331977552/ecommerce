package com.food.exception;

public class CreationException extends BaseEntityException {
    public CreationException(String message) {
        super(message);
    }

    public CreationException(String message, String[] args) {
        super(message, args);
    }

    public CreationException(String title, String message) {
        super(title, message);
    }

    public CreationException(String title, String message, String... args) {
        super(title, message, args);
    }

    public CreationException(String title, Throwable cause) {
        super(title, cause);
    }
}
