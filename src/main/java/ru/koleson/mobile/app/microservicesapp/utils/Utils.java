package ru.koleson.mobile.app.microservicesapp.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generatedUserId() {
        return UUID.randomUUID().toString();
    }
}
