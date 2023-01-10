package br.com.areadigital.web.controller.exceptions;

import br.com.areadigital.web.service.exceptions.DatabaseException;
import br.com.areadigital.web.service.exceptions.ResourceNotFoundException;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ResourceExceptionHandler {

    private final MeterRegistry registry;

    private void setLogErro(HttpStatus status, HttpServletRequest request) {
        registry.counter(String.valueOf(status.value())).increment();
        log.error("Error {} method {} Url {}", status.value(), request.getMethod(), request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> validation(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Internal processing failure");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        setLogErro(status, request);
        try {
            err.addError("message", e.getCause().getMessage());
        } catch (Exception exception) {
            err.addError("message", "");
        }
            return ResponseEntity.status(status).body(err);



    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> entityMethodNotAllowedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Method Not Allowed");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        setLogErro(status, request);
        return ResponseEntity.status(status).body(err);
    }

//    @ExceptionHandler( ResourceNotFoundException.class)
//    public ResponseEntity<StandardError> entityResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
//        HttpStatus status = HttpStatus.NOT_FOUND;
//        StandardError err = new StandardError();
//        err.setTimestamp(Instant.now());
//        err.setStatus(status.value());
//        err.setError("Resource Not Found");
//        err.setMessage(e.getMessage());
//        err.setPath(request.getRequestURI());
//        setLogErro(status, request);
//        return ResponseEntity.status(status).body(err);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        setLogErro(status, request);
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Database exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        setLogErro(status, request);
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Validation exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        setLogErro(status, request);

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }
}
