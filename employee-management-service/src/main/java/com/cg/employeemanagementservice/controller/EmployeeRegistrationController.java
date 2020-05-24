	package com.cg.employeemanagementservice.controller;

import com.cg.employeemanagementservice.entity.EmployeeDetails;
import com.cg.employeemanagementservice.entity.User;
import com.cg.employeemanagementservice.service.EmployeeRegistrationService;
import com.cg.employeemanagementservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:41
 */

/**
 * @CrossOrigin - To fix cross origin error
 * @Controller - Used to Register/ Update a new Employee
 */
@CrossOrigin("*")
@RestController
@Api("Manage employee related operations")
public class EmployeeRegistrationController {

    @Autowired
    private EmployeeRegistrationService employeeRegistrationService;

    @Autowired
    private UserService userService;

    /**
     * Add a new emloyee details using post mapping
     */
    @PostMapping("/employees")
    @ApiOperation(value = "Adds new employee details")
    public ResponseEntity<EmployeeDetails> addEmployee(@RequestBody User user){
        EmployeeDetails employeeDetails = employeeRegistrationService.addEmployeeDetails(user);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

    /**
     * Adds Employee Details + User credentials
     */
    @PostMapping("/employees/user")
    @ApiOperation(value = "Adds new user details")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    /**
     * 
     * @param details Employee Details to be Updated
     * @return Retuns a response Entity container
     */
    @PutMapping("/employees")
    @ApiOperation(value = "Updates employee details")
    public ResponseEntity<EmployeeDetails> updateEmployeeDetails(@RequestBody EmployeeDetails details){
        EmployeeDetails employeeDetails = employeeRegistrationService.updateEmployeeDetails(details);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

}
