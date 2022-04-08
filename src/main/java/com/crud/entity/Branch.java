package com.crud.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long branchId;

    @NotBlank
    private String branchName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private Company company;

}
