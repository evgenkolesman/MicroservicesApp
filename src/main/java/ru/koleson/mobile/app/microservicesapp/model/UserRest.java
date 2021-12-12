package ru.koleson.mobile.app.microservicesapp.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRest {

    private String firstName;

    private String lastName;

    private String email;

    private String userId;


}
