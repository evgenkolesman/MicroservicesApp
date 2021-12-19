package ru.koleson.mobile.app.microservicesapp.service;

import org.springframework.http.ResponseEntity;
import ru.koleson.mobile.app.microservicesapp.model.UserDetailRequestModel;
import ru.koleson.mobile.app.microservicesapp.model.UserRest;

public interface UserService {

   UserRest createUser(UserDetailRequestModel userDetailRequestModel);
}
