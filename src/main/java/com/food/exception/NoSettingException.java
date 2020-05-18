package com.food.exception;

import com.food.utils.BaseEntityException;

public class NoSettingException extends BaseEntityException {

    public NoSettingException(String message) {
        super(message);
    }

    public NoSettingException(String message, String[] args) {
        super(message, args);
    }

    public NoSettingException(String title, String message, String ...args) {
        super(title, message, args);
    }

    public NoSettingException(String title, String message) {
        super(title, message);
    }

    public NoSettingException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public NoSettingException(String title, Throwable cause) {
        super(title, cause);
    }

    public NoSettingException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(title, message, cause, enableSuppression, writableStackTrace);
    }
}