/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 01:50:36
 * @modify date 2020-05-06 01:50:36
 * @desc Perform CRUD operation with basic user credentials
 */
package com.cg.employeeloginservice.repository;

import com.cg.employeeloginservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    
}
