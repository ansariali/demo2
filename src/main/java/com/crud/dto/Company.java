package com.crud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Company {
    private String companyName;
    private String gstNumber;
    private String registrationNumber;
    private List<User> users;

    @Setter
    @Getter
    public static class User {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private String password;
    }
}
