package ru.koleson.mobile.app.microservicesapp.service.implementations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.koleson.mobile.app.microservicesapp.model.UserDetailRequestModel;
import ru.koleson.mobile.app.microservicesapp.model.UserRest;
import ru.koleson.mobile.app.microservicesapp.service.UserService;
import ru.koleson.mobile.app.microservicesapp.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    private final Utils utils;

//    @Autowired
//    public UserServiceImpl(Utils utils) {
//        this.utils = utils;
//    }

    @Override
    public UserRest createUser(UserDetailRequestModel userDetailRequestModel) {
        
        UserRest userRest = UserRest.of(userDetailRequestModel);
        userRest.setUserId(utils.generatedUserId());

        if (users == null) {
            users = new HashMap<>();
        }
        
        users.put(userRest.getUserId(), userRest);

        return userRest;
    }
}
