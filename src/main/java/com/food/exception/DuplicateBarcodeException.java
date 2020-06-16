package com.food.exception;

public class DuplicateBarcodeException extends BaseEntityException {

    public DuplicateBarcodeException(String message) {
        super(message);
    }

    public DuplicateBarcodeException(String message, String[] args) {
        super(message, args);
    }

    public DuplicateBarcodeException(String title, String message, String ...args) {
        super(title, message, args);
    }

    public DuplicateBarcodeException(String title, String message) {
        super(title, message);
    }

    public DuplicateBarcodeException(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public DuplicateBarcodeException(String title, Throwable cause) {
        super(title, cause);
    }

    public DuplicateBarcodeException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(title, message, cause, enableSuppression, writableStackTrace);
    }
}
