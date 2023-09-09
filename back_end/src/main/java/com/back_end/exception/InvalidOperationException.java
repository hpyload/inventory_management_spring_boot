package com.back_end.exception;

import lombok.Getter;

@Getter
public class InvalidOperationException extends RuntimeException {

    private final String message;
    public InvalidOperationException(String message) {
        this.message = message;
    }
}
