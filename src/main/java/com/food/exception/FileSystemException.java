package com.food.exception;

public class FileSystemException extends RuntimeException {
    public FileSystemException() {
    }

    public FileSystemException(String s) {
        super(s);
    }

    public FileSystemException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FileSystemException(Throwable throwable) {
        super(throwable);
    }

    public FileSystemException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
