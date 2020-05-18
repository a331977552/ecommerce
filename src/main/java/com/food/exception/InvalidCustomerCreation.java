package com.food.exception;

import com.food.utils.BaseEntityException;
public class InvalidCustomerCreation extends BaseEntityException {
    public InvalidCustomerCreation(String message) {
        super(message);
    }

    public InvalidCustomerCreation(String message, String[] args) {
        super(message, args);
    }

    public InvalidCustomerCreation(String title, String message) {
        super(title, message);
    }

    public InvalidCustomerCreation(String title, String message, String... args) {
        super(title, message, args);
    }

    public InvalidCustomerCreation(String title, String message, Throwable cause) {
        super(title, message, cause);
    }

    public InvalidCustomerCreation(String title, Throwable cause) {
        super(title, cause);
    }
}
