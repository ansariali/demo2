package com.crud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;

    public Company(String companyName, String gstNumber, String registrationNumber) {
        this.companyName = companyName;
        this.gstNumber = gstNumber;
        this.registrationNumber = registrationNumber;
    }

    @NotBlank
    private String companyName;

    @NotBlank
    private String gstNumber;

    @NotBlank
    private String registrationNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    private Set<User> users = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Branch> branches = new HashSet<>();

}
