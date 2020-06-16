package com.food.exception;

public class NoSuchEntityException extends BaseEntityException {
    public NoSuchEntityException(String message) {
        super(message);
    }



    public NoSuchEntityException(String title, String message) {
        super(title, message);
    }

    public NoSuchEntityException(String title, String message, String... args) {
        super(title, message, args);
    }

    public NoSuchEntityException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public NoSuchEntityException(String title, Throwable cause) {
        super(title, cause);
    }

    public NoSuchEntityException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(title, message, cause, enableSuppression, writableStackTrace);
    }

    public NoSuchEntityException(String message, String[] args) {
        super(message, args);
    }
}
