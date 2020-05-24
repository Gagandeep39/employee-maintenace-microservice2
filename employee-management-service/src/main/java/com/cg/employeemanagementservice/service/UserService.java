package com.cg.employeemanagementservice.service;

import com.cg.employeemanagementservice.entity.User;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 02:13
 */

/**
 * Interservice Communication with The login service to store user credentials
 */
public interface UserService {

    /**
     * Adds a new user and returns the ID generated for that user
     * @param user Adds a new User
     * @return A User Object with ID
     */
    User addUser(User user);

}
