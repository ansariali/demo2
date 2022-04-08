package com.crud.service.serviceImpl;

import com.crud.ExptionHandler.GenericException;
import com.crud.config.GenericResponse;
import com.crud.dto.RegistrationRequest;
import com.crud.entity.Company;
import com.crud.entity.User;
import com.crud.repository.CompanyRepository;
import com.crud.repository.UserRepository;
import com.crud.service.CompanyService;
import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public CompanyServiceImpl(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }


    @Override
    public GenericResponse registration(RegistrationRequest registrationRequest) {
        Optional<User> userName = userRepository.findByUserName(registrationRequest.getUserName());
        if (userName.isPresent()) {
            throw new GenericException("User Name already exits");
        }
        User email = userRepository.findByEmail(registrationRequest.getEmail());
        if (email != null) {
            throw new GenericException("Email already exits");
        }

        Company company = new Company(registrationRequest.getCompanyName(), registrationRequest.getGstNumber(), registrationRequest.getRegistrationNumber());
        User user = new User(registrationRequest.getFirstName(), registrationRequest.getLastName(), registrationRequest.getUserName(), registrationRequest.getEmail(), registrationRequest.getPassword());
        company = companyRepository.save(company);
        user.setCompany(company);
        userRepository.save(user);
        return new GenericResponse(HttpStatus.OK, null, "Registration SuccessFully");
    }

    @Override
    public GenericResponse fetchCompanyById(Long companyId) {
        return new GenericResponse(HttpStatus.OK, dozerBeanMapper.map(companyRepository.findById(companyId).orElseThrow(() -> new GenericException("Company id not found")), com.crud.dto.Company.class), "Fetch Company Details");
    }

    @Override
    public GenericResponse fetchUserById(Long userId) {
        return new GenericResponse(HttpStatus.OK, dozerBeanMapper.map(userRepository.findById(userId).orElseThrow(() -> new GenericException("User id not found")), com.crud.dto.User.class), "Fetch user detail");
    }

    @Override
    public GenericResponse fetchAll() {
        return new GenericResponse(HttpStatus.OK, companyRepository.findAll(), "fetch all company");
    }
}
