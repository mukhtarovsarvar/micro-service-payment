package com.click.dto.profile;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDTO {

    @NotBlank(message = "Name not null")
    private String name;

    @NotBlank(message = "Surname not null")
    private String username;

    @NotBlank(message = "Password not null")
    private String password;

    @NotBlank(message = "PhoneNumber not null")
    private String phone;
}
