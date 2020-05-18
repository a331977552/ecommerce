package com.food.exception;

import com.food.utils.BaseEntityException;

public class UnexpectedException extends BaseEntityException {
    public UnexpectedException(String arg) {
        this("unexpected exception","unexpected.error", arg);
    }


     private UnexpectedException(String title, String message, String... args) {
        super(title, message, args);
    }



}
