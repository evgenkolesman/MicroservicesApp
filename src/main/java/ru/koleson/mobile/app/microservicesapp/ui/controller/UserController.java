package ru.koleson.mobile.app.microservicesapp.ui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("users") //http:/localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser() {
        return "";
    }

    @PostMapping
    public String createUser() {
        return "";
    }

    @PutMapping
    public String UpdateUser() {
        return "";
    }

    @DeleteMapping
    public String deleteUser() {
        return "";
    }
}
