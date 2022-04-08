package com.crud.service;

import com.crud.config.GenericResponse;
import com.crud.dto.RegistrationRequest;

public interface CompanyService {
     GenericResponse registration(RegistrationRequest company);

     GenericResponse fetchCompanyById(Long companyId);

     GenericResponse fetchUserById(Long userId);

     GenericResponse fetchAll();
}
