/* 
@author Pranav Karmarkar
*/

package com.cg.employeevalidationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeevalidationservice.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
