package ru.koleson.mobile.app.microservicesapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.koleson.mobile.app.microservicesapp.response.ExceptionMessage;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException (Exception e, WebRequest req) {

        String exceptionMessageDescription = e.getLocalizedMessage();

        if(exceptionMessageDescription == null) exceptionMessageDescription = e.toString();
        ExceptionMessage ex = new ExceptionMessage(new Date(), exceptionMessageDescription);
        return  new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
