package com.food.exception;

import com.food.utils.BaseEntityException;

public class EntityDeleteException extends BaseEntityException {
    public EntityDeleteException(String message) {
        super(message);
    }

    public EntityDeleteException(String message, String[] args) {
        super("entity delete exception",message, args);
    }

    public EntityDeleteException(String title, String message) {
        super(title, message);
    }

    public EntityDeleteException(String title, String message, String... args) {
        super(title, message, args);
    }

    public EntityDeleteException(String title, Throwable cause) {
        super(title, cause);
    }
}
