package com.crud.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegistrationRequest {
    @NotBlank(message = "company name should not be blank")
    private String companyName;
    @NotBlank
    private String gstNumber;
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Column(unique = true)
    private String userName;
    @Email
    private String email;
    @NotBlank
    private String password;
}
