package com.crud.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericResponse {
    public GenericResponse(HttpStatus httpStatus, Object feed, String message) {
        this.httpStatus = httpStatus;
        this.feed = feed;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private Object feed;
    private String message;

}
