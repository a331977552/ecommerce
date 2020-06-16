package com.food.exception;

public class CustomerAlreadyExist extends BaseEntityException {
    public CustomerAlreadyExist(String message) {
        super(message);
    }

    public CustomerAlreadyExist(String message, String[] args) {
        super(message, args);
    }

    public CustomerAlreadyExist(String title, String message) {
        super(title, message);
    }

    public CustomerAlreadyExist(String title, String message, String... args) {
        super(title, message, args);
    }


}
