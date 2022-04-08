package com.crud.ExptionHandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> aMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(err -> {
            aMap.put(err.getField(), err.getDefaultMessage());
        });
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, "Field Validation", ErrorType.ERR, aMap);
    }

    @ExceptionHandler(GenericException.class)
    public Object genericException(GenericException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage(), ErrorType.ERR, null);
    }


    @Getter
    public static class ErrorResponse {
        private HttpStatus httpStatus;
        private String message;
        private ErrorType messageType;
        private Map<String, String> validations;

        public ErrorResponse(HttpStatus httpStatus, String message, ErrorType messageType, Map<String, String> validations) {
            this.httpStatus = httpStatus;
            this.message = message;
            this.messageType = messageType;
            this.validations = validations;
        }
    }
}
