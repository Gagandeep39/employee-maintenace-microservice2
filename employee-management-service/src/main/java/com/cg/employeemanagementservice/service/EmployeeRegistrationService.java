package com.cg.employeemanagementservice.service;

import com.cg.employeemanagementservice.entity.EmployeeDetails;
import com.cg.employeemanagementservice.entity.User;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:37
 */
public interface EmployeeRegistrationService {

    /**
     * Add a new User with credentials
     * @param user Complete user object with User credential and Employee Details
     * @return Details of the added Employee
     */
    EmployeeDetails addEmployeeDetails(User user);

    /**
     * @param details The user details to be updated
     * @return Updated Data from database
     */
	EmployeeDetails updateEmployeeDetails(EmployeeDetails details);

}
