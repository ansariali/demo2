package com.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Company company;

    @Getter
    @Setter
    public static class Company {
        private String companyName;
        private String gstNumber;
        private String registrationNumber;
    }
}
