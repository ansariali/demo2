package com.crud.controller;

import com.crud.dto.RegistrationRequest;
import com.crud.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/company/")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createCompany(@Valid @RequestBody RegistrationRequest registrationRequest) {
        log.info("createCompany");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyService.registration(registrationRequest));
    }

    @GetMapping("fetchById/{companyId}")
    public ResponseEntity<?> fetchCompanyById(@PathVariable(name = "companyId") Long companyId) {
        log.info("fetchCompanyById");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.fetchCompanyById(companyId));
    }

    @GetMapping("fetchAll")
    public ResponseEntity<?> fetchAll() {
        log.info("fetchAll");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.fetchAll());
    }

    @GetMapping("fetchUserById/{userId}")
    public ResponseEntity<?> fetchUserById(@PathVariable(name = "userId") Long userId) {
        log.info("fetchUserById");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.fetchUserById(userId));
    }
}
