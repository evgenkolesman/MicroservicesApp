package ru.koleson.mobile.app.microservicesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UpdateRequestUserModel {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
