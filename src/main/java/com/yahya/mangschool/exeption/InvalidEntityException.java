package com.yahya.mangschool.exeption;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;
    @Getter
    private String errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode, String errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
