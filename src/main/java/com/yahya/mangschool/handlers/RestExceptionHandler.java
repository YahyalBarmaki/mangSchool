package com.yahya.mangschool.handlers;

import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.exeption.InvalidEntityException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> handleException(ConstraintViolationException exception) {

        final HttpStatus notFound = HttpStatus.BAD_REQUEST;
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        System.out.println(constraintViolations
                .size());
        Map<String,String> data = new HashMap<>();
        constraintViolations.forEach(
                item->{
                    System.out.println(item.getPropertyPath());
                    data.put(String.valueOf(item.getPropertyPath()),item.getMessage());
                }
        );
        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.BAD_REQUEST)
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(data, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDto> handleException(EmptyResultDataAccessException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.NOT_FOUND;

        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.NOT_FOUND)
                .httpCode(badRequest.value())
                .message("Les ressources demandées déjà supprimées")
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
}
