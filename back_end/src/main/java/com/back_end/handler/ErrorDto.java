package com.back_end.handler;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {
    private Date timestamp;
    private ErrorCode errorCode;
    private String message;
    private List<String> errors = new ArrayList<>();

    public ErrorDto(Date timestamp, ErrorCode errorCode, String message, List<String> errors) {
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
        this.errors = errors;
    }

    public ErrorDto(Date timestamp, ErrorCode errorCode, String message) {
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
    }
}