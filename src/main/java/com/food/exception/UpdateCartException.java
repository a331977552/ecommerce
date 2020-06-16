package com.food.exception;

public class UpdateCartException  extends BaseEntityException {

    public UpdateCartException(String message) {
        super(message);
    }

    public UpdateCartException(String message, String[] args) {
        super(message, args);
    }

    public UpdateCartException(String title, String message) {
        super(title, message);
    }

    public UpdateCartException(String title, String message, String... args) {
        super(title, message, args);
    }

    public UpdateCartException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public UpdateCartException(String title, Throwable cause) {
        super(title, cause);
    }
}
