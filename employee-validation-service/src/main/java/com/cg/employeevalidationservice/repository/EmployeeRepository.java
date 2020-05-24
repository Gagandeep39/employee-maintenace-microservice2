/* 
@author Pranav Karmarkar
*/

package com.cg.employeevalidationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.employeevalidationservice.entity.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {

	@Query(value="SELECT emp_details.emp_id, emp_details.first_name, emp_details.last_name FROM user_master INNER JOIN emp_details "
			+ "ON emp_details.emp_id = user_master.user_id WHERE user_master.role_id=100002 ", nativeQuery = true)
	List<Object[]> findAllManagers();
}
