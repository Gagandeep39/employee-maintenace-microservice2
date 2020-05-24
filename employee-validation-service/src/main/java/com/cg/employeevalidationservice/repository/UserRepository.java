/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 02:21:06
 * @modify date 2020-05-11 02:21:06
 * @desc Userrepoisotry
 */
package com.cg.employeevalidationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.cg.employeevalidationservice.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    @Query("select u.empId, u.employeeDetails.firstName, u.employeeDetails.lastName from User u where u.role.roleId=100002")
    List<Object[]> findAllManagers();
}
