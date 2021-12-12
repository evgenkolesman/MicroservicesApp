package ru.koleson.mobile.app.microservicesapp.model;


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

//    private String password;


    public static UserRest of(UserDetailRequestModel user) {
        UserRest userRest = new UserRest();
        userRest.setFirstName(user.getFirstName());
        userRest.setLastName(user.getLastName());
        userRest.setEmail(user.getEmail());
//        userRest.setPassword(user.getPassword());
        return userRest;
    }
}
