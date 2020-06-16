package com.food.exception;

public class NullImgException extends BaseEntityException {
    public NullImgException(String message) {
        super(message);
    }

    public NullImgException(String message, String[] args) {
        super(message, args);
    }

    public NullImgException(String title, String message) {
        super(title, message);
    }

    public NullImgException(String title, String message, String... args) {
        super(title, message, args);
    }

    public NullImgException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public NullImgException(String title, Throwable cause) {
        super(title, cause);
    }

    public NullImgException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(title, message, cause, enableSuppression, writableStackTrace);
    }
}
