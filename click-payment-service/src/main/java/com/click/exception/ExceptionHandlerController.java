package com.click.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.DefaultResponseErrorHandler;

@ControllerAdvice
public class ExceptionHandlerController extends DefaultResponseErrorHandler {

    @ExceptionHandler({ItemNotFoundException.class,
            AppBadRequestException.class, NullPointerException.class})
    public ResponseEntity<?> handleBadRequestException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }



/*    @ExceptionHandler({AppForbiddenException.class})
    public ResponseEntity<?> handleForbiddenException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }*/

/*    @ExceptionHandler({TokenNotValidException.class})
    public ResponseEntity<?> handleTokenException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }*/

/*
    @ExceptionHandler({AppNotAcceptableException.class})
    public ResponseEntity<?> handleNotAcceptableException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }*/
}
