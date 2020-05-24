/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 03:08:33
 * @modify date 2020-05-06 03:08:33
 * @desc Employee Service operations
 */
package com.cg.employeeloginservice.service;


import com.cg.employeeloginservice.model.ChangePassword;
import com.cg.employeeloginservice.entity.User;

public interface UserService {

    User performLogin(User user);
    User changePassword(ChangePassword changePassword);
    User addUser(User user);
	User updateRole(User user);
	User findUserById(Integer id);

}
