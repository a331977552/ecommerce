package com.food.exception;

public class UnexpectedException extends BaseEntityException {
    public UnexpectedException(String arg) {
        this("unexpected exception","unexpected.error", arg);
    }


     private UnexpectedException(String title, String message, String... args) {
        super(title, message, args);
    }





}
