package com.wb.employeeservice.exception.handler;


import com.wb.employeeservice.exception.BadRequestException;
import com.wb.employeeservice.exception.NotFoundException;
import com.wb.employeeservice.exception.details.CustomExceptionDetails;
import com.wb.employeeservice.exception.details.ValidationExceptionDetails;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String BAD_REQUEST_MESSAGE = "Bad Request Exception, check the documentation";
    public static final String NOT_FOUND_REQUEST_MESSAGE = "Not Found Exception, check the documentation";
    public static final String UNAUTHORIZED_REQUEST_MESSAGE = "Unauthorized Exception, check the documentation";
    public static final String FORBIDDEN_REQUEST_MESSAGE = "Forbidden Exception, check the documentation";
    public static final String METHOD_NOT_ALLOWED_REQUEST_MESSAGE = "Method Not Allowed Exception, check the documentation";

//    @ExceptionHandler({BadCredentialsException.class})
//    public ResponseEntity<CustomExceptionDetails> handlerBadCredentialsException(
//            @NonNull WebRequest request,
//            @NonNull BadCredentialsException unauthorized) {
//        return new ResponseEntity<>(
//                CustomExceptionDetails.builder()
//                        .timestamp(LocalDateTime.now())
//                        .status(HttpStatus.UNAUTHORIZED.value())
//                        .title(UNAUTHORIZED_REQUEST_MESSAGE)
//                        .details(unauthorized.getMessage())
//                        .developerMessage(unauthorized.getClass().getName())
//                        .path(request.getDescription(false))
//                        .build(), HttpStatus.UNAUTHORIZED);
//    }

//    @ExceptionHandler({Unauthorized.class})
//    @ExceptionHandler({AccountNotFoundException.class})
//    @ExceptionHandler({InsufficientAuthenticationException.class})

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<CustomExceptionDetails> handlerNullPointerException(
            @NonNull WebRequest request,
            @NonNull NullPointerException ex) {
        return new ResponseEntity<>(CustomExceptionDetails
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title(BAD_REQUEST_MESSAGE)
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .path(request.getDescription(false))
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<CustomExceptionDetails> handlerHttpMessageNotReadableException(
            @NonNull WebRequest request,
            @NonNull HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(CustomExceptionDetails
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title(BAD_REQUEST_MESSAGE)
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .path(request.getDescription(false))
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<CustomExceptionDetails> handlerMethodNotAllowedException(
            @NonNull WebRequest request,
            @NonNull HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                        .title(METHOD_NOT_ALLOWED_REQUEST_MESSAGE)
                        .details(ex.getMessage())
                        .developerMessage(ex.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<CustomExceptionDetails> handlerAccessDeniedException(
            @NonNull WebRequest request,
            @NonNull AccessDeniedException forbidden) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.FORBIDDEN.value())
                        .title(BAD_REQUEST_MESSAGE)
                        .details(forbidden.getMessage())
                        .developerMessage(forbidden.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<CustomExceptionDetails> handlerBadRequestException(
            @NonNull WebRequest request,
            @NonNull BadRequestException bre) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title(BAD_REQUEST_MESSAGE)
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<CustomExceptionDetails> handlerNotFoundException(
            @NonNull WebRequest request,
            @NonNull NotFoundException nre) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title(NOT_FOUND_REQUEST_MESSAGE)
                        .details(nre.getMessage())
                        .developerMessage(nre.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<CustomExceptionDetails> handlerEntityNotFoundException(
            @NonNull WebRequest request,
            @NonNull EntityNotFoundException nre) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title(NOT_FOUND_REQUEST_MESSAGE)
                        .details(nre.getMessage())
                        .developerMessage(nre.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler({ResourceAccessException.class})
//    public ResponseEntity<CustomExceptionDetails> handlerNotFoundException(
//            @NonNull WebRequest request,
//            @NonNull ResourceHttpRequestHandler ex) {
//        return new ResponseEntity<>(
//                CustomExceptionDetails.builder()
//                        .timestamp(LocalDateTime.now())
//                        .status(HttpStatus.NOT_FOUND.value())
//                        .title(NOT_FOUND_REQUEST_MESSAGE)
//                        .details(ex.getMessage())
//                        .developerMessage(ex.getClass().getName())
//                        .path(request.getDescription(false))
//                        .build(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(
            @NonNull WebRequest request,
            @NonNull MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<String> fields = new ArrayList<>();
        List<String> fieldsMessage = new ArrayList<>();

        fieldErrors.forEach(e -> fields.add(e.getField()));
        fieldErrors.forEach(e -> fieldsMessage.add(e.getDefaultMessage()));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Invalid Fields")
                        .details("check the field(s) error")
                        .developerMessage(exception.getClass().getName())
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)
                        .path(request.getDescription(false))
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<CustomExceptionDetails> handlerDataIntegrityViolationException(
            @NonNull WebRequest request,
            @NonNull DataIntegrityViolationException ex) {

        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title(BAD_REQUEST_MESSAGE)
                        .details(ex.getMessage())
                        .developerMessage(ex.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<CustomExceptionDetails> handlerIllegalStateExceptionException(
            @NonNull WebRequest request,
            @NonNull IllegalStateException ex) {

        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title(BAD_REQUEST_MESSAGE)
                        .details(ex.getMessage())
                        .developerMessage(ex.getClass().getName())
                        .path(request.getDescription(false))
                        .build(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
//    public ResponseEntity<CustomExceptionDetails> handlerSQLIntegrityConstraintViolationException(
//            @NonNull WebRequest request,
//            @NonNull DataIntegrityViolationException exception) {
//
//        return new ResponseEntity<>(
//                CustomExceptionDetails.builder()
//                        .timestamp(LocalDateTime.now())
//                        .status(HttpStatus.BAD_REQUEST.value())
//                        .title("Bad Request Exception, check the documentation")
//                        .details("Duplicate entry " + exception.getMessage())
//                        .developerMessage(exception.getClass().getName())
//                        .path(request.getRequestURI())
//                        .build(), HttpStatus.BAD_REQUEST);
//    }
}//SQLIntegrityConstraintViolationException
