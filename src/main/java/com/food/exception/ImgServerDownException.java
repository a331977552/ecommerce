package com.food.exception;

public class ImgServerDownException extends BaseEntityException {
    public ImgServerDownException(String message) {
        super(message);
    }

    public ImgServerDownException(String message, String[] args) {
        super(message, args);
    }

    public ImgServerDownException(String title, String message) {
        super(title, message);
    }

    public ImgServerDownException(String title, String message, String... args) {
        super(title, message, args);
    }

    public ImgServerDownException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public ImgServerDownException(String title, Throwable cause) {
        super(title, cause);
    }

    public ImgServerDownException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(title, message, cause, enableSuppression, writableStackTrace);
    }
}
