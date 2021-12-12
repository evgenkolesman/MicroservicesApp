package ru.koleson.mobile.app.microservicesapp.ui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.koleson.mobile.app.microservicesapp.model.UpdateRequestUserModel;
import ru.koleson.mobile.app.microservicesapp.model.UserDetailRequestModel;
import ru.koleson.mobile.app.microservicesapp.model.UserRest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/USERS") //http:/localhost:8080/users
public class UserController {
    Map<String, UserRest> users;

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity getUser(@PathVariable String userId
    ) {
        String f = null;
        int fLength = f.length();
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public String getUser(@RequestParam(name = "page", defaultValue = "1") int page,
                          @RequestParam(name = "limit", defaultValue = "15") int limit,
                          @RequestParam(value = "sort", defaultValue = "desc",
                                  required = false) String sort) {

        return "return GET page = " + page + " limit = " + limit + " sort " + sort;
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity createUser(@Valid @RequestBody UserDetailRequestModel userDetailRequestModel) {
        UserRest userRest = UserRest.of(userDetailRequestModel);
        userRest.setUserId(UUID.randomUUID().toString());
        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userRest.getUserId(), userRest);

        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateRequestUserModel user) {
        UserRest storedUserRest = users.get(userId);
        storedUserRest.setFirstName(user.getFirstName());
        storedUserRest.setLastName(user.getLastName());
        users.put(userId, storedUserRest);
        return storedUserRest;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        if (users.containsKey(userId)) users.remove(users.get(userId));

        return ResponseEntity.noContent().build();
    }
}
