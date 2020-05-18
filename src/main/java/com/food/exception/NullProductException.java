package com.food.exception;

import com.food.utils.BaseEntityException;
public class NullProductException extends BaseEntityException {

    public NullProductException(String message) {
        super(message);
    }

    public NullProductException(String message, String[] args) {
        super(message, args);
    }

    public NullProductException(String title, String message) {
        super(title, message);
    }

    public NullProductException(String title, String message, String[] args) {
        super(title, message, args);
    }

    public NullProductException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public NullProductException(String title, Throwable cause) {
        super(title, cause);
    }

    public NullProductException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(title, message, cause, enableSuppression, writableStackTrace);
    }
}
