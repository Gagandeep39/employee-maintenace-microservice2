package com.cg.employeeloginservice.controller;

import com.cg.employeeloginservice.model.ChangePassword;
import com.cg.employeeloginservice.entity.User;
import com.cg.employeeloginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Gagandeep
 * @date 06-05-2020
 * @time 02:52
 */

@CrossOrigin("*")
@RestController
@Api("Manage login related operations")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "Logs in to system")
    public ResponseEntity<User> performLogin(@RequestBody User user){
        User loggedInUser = userService.performLogin(user);
        return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
    }

    @PostMapping("/login/add")
    @ApiOperation(value = "Adds new user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Changes password of user")
    @PostMapping("/login/change")
    public ResponseEntity<User> changePassword(@RequestBody ChangePassword changePassword) {
        User modifiedUser = userService.changePassword(changePassword);
        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    @PutMapping("/login/update")
    @ApiOperation(value = "Update details of user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User modifiedUser = userService.updateRole(user);
        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    @GetMapping("/login/{id}")
    @ApiOperation(value = "Fetches user by Id")
    public ResponseEntity<User> fetchUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
