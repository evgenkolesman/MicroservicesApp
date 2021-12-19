package ru.koleson.mobile.app.microservicesapp.exceptions;


import java.io.Serial;

public class UserServiceException extends RuntimeException{


    @Serial
    private static final long serialVersionUID = 6446053052147524133L;

    public UserServiceException(String message) {
        super(message);
    }


}
