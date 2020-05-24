package com.cg.employeemanagementservice.service.implementation;

import com.cg.employeemanagementservice.entity.Address;
import com.cg.employeemanagementservice.entity.EmployeeDetails;
import com.cg.employeemanagementservice.entity.User;
import com.cg.employeemanagementservice.repository.EmployeeDetailsRepository;
import com.cg.employeemanagementservice.service.EmployeeRegistrationService;
import com.cg.employeemanagementservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:38
 */

@Service
@Slf4j
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Override
    public EmployeeDetails addEmployeeDetails(User user) {
        // Separating objects
        EmployeeDetails details = user.getEmployeeDetails();
        Address address = details.getAddress();
        // Saving user credentials
        User addedUser = saveAndFetchId(user);
        // Initializing objects
        details.setEmpDetailsId(addedUser.getEmpId());
        // If nt setting the whole object, then we have to atleast set the details.user.id
        details.setUser(addedUser);
        address.setEmployeeDetails(details);
        // Saving objects
        return employeeDetailsRepository.save(details);
    }

    private User saveAndFetchId(User user) {
        user.setEmployeeDetails(null);
        User addedUser = userService.addUser(user);
        if (addedUser.getEmpId()==0)
            throw new RuntimeException("Registration Failed: Error Communicating with Login Service");
        return addedUser;
    }

    @Override
    public EmployeeDetails updateEmployeeDetails(EmployeeDetails details) {
        details.getAddress().setAddressId(details.getEmpDetailsId());
        return employeeDetailsRepository.save(details);
    }
}
