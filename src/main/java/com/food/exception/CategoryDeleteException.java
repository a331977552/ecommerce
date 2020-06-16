package com.food.exception;

public class CategoryDeleteException extends BaseEntityException {
    public CategoryDeleteException(String message) {
        super(message);
    }

    public CategoryDeleteException(String message, String[] args) {
        super(message, args);
    }

    public CategoryDeleteException(String title, String message) {
        super(title, message);
    }

    public CategoryDeleteException(String title, String message, String... args) {
        super(title, message, args);
    }

    public CategoryDeleteException(String title, Throwable cause) {
        super(title, cause);
    }
}
