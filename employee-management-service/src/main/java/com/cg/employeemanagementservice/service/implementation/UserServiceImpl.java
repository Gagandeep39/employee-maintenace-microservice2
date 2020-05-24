package com.cg.employeemanagementservice.service.implementation;

import com.cg.employeemanagementservice.entity.User;
import com.cg.employeemanagementservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 02:13
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private User dummyUser;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackAddUser")
    public User addUser(User user) {
        // User addedUser = 
        return restTemplate.postForObject("http://employee-login-service/login/add", user, User.class);
    }

    /**
     * Fallback Method
     * NOTE: Throwing excetion from fallback will cause it to fail
     * @param user To be stored saved in user database
     * @return User Object with a generated ID
     */
    public User fallbackAddUser(User user, Throwable throwable) {
        log.info("Fallback Reason: " + throwable.getMessage());
        return dummyUser;
    }

}
