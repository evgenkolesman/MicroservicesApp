package ru.koleson.mobile.app.microservicesapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {

    private Date timestamp;

    private String message;
}
