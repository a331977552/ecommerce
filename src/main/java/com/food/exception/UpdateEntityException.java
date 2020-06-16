package com.food.exception;

public class UpdateEntityException extends BaseEntityException {

    public UpdateEntityException(String message) {
        super(message);
    }

    public UpdateEntityException(String message, String[] args) {
        super(message, args);
    }

    public UpdateEntityException(String title, String message) {
        super(title, message);
    }

    public UpdateEntityException(String title, String message, String... args) {
        super(title, message, args);
    }

    public UpdateEntityException(String title, Throwable cause) {
        super(title, cause);
    }
}
