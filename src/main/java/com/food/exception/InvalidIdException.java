package com.food.exception;

public class InvalidIdException extends BaseEntityException {
    public InvalidIdException(String message) {
        super(message);

    }

    public InvalidIdException(String message, String[] args) {
        super(message, args);
    }

    public InvalidIdException(String title, String message) {
        super(title, message);
    }

    public InvalidIdException(String title, String message, String... args) {
        super(title, message, args);
    }

    public InvalidIdException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public InvalidIdException(String title, Throwable cause) {
        super(title, cause);
    }

}
