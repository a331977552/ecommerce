package com.food.utils;

import java.util.Arrays;

public class BaseEntityException extends RuntimeException {
    private String title;

    private String[] args;

    public String[] getArgs() {
        return args;
    }


    public void setArgs(String ...args) {
        this.args = args;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseEntityException(String message) {
        super(message);
        this.title="";
    }

    public BaseEntityException(String message, String []args) {
        super(message);
        this.title="";
        this.args=args;
    }


    public BaseEntityException(String title, String message) {
        super(message);
        this.title=title;
        this.args=new String[]{message};
    }

    public BaseEntityException(String title, String message, String ...args) {
        super(message);
        this.title=title;
        this.args=args;
    }
    public BaseEntityException(String title, String message, Throwable cause) {
        super(message, cause);
        this.title=title;
        this.args=new String[]{message};
    }

    public BaseEntityException(String title, Throwable cause) {
        super(cause);
        this.title=title;
    }

    public BaseEntityException(String title, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.title=title;
        this.args=new String[]{message};
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " {" +
                "title='" + title + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
