/* 
@author Pranav Karmarkar
*/

package com.cg.employeevalidationservice.service;

import java.util.List;

import com.cg.employeevalidationservice.entity.Department;
import com.cg.employeevalidationservice.entity.Grade;
import com.cg.employeevalidationservice.entity.Manager;
import com.cg.employeevalidationservice.entity.Role;

public interface ValidationService {

	List<Grade> fetchAllGrades();
	List<Department> fetchAllDepartments();
	List<Manager> fetchAllManagers();
	boolean usernameExists(String username);
	List<Role> fetchRoles();
}
