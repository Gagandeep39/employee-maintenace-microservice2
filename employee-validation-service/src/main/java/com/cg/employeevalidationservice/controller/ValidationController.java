/* 
@author Pranav Karmarkar
*/
package com.cg.employeevalidationservice.controller;

import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.cg.employeevalidationservice.entity.Department;
import com.cg.employeevalidationservice.entity.Grade;
import com.cg.employeevalidationservice.entity.Manager;
import com.cg.employeevalidationservice.entity.Role;
import com.cg.employeevalidationservice.service.ValidationService;

@CrossOrigin("*")
@RestController
@Slf4j
@Api("To fetch data for validation and population of various dropdowns ")
public class ValidationController {

	@Autowired
	private ValidationService validationService;
	
	@GetMapping("/grades")
	@ApiOperation(value = "Fetches all grades")
	public List<Grade> fetchAllGrades(){
		List<Grade> grades = validationService.fetchAllGrades();
		return grades;
	}
	
	@GetMapping("/departments")
	@ApiOperation(value = "Fetches all departments")
	public List<Department> fetchAllDepartments(){
		List<Department> departments = validationService.fetchAllDepartments();
		return departments;
	}
	
	@GetMapping("/managers")
	@ApiOperation(value = "Fetches all managers")
	public List<Manager> fetchAllManagers(){
		List<Manager> managers = validationService.fetchAllManagers();
		return managers;
	}

	@GetMapping("/username")
	@ApiOperation(value = "Check if username exists in database")
	public ResponseEntity<HashMap<String, Boolean>> checkUsernameExist(@RequestParam String username){
		HashMap<String, Boolean> map = new HashMap<>();
		log.info("----------------" + username);
		map.put("exists", validationService.usernameExists(username));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/roles")
	@ApiOperation(value = "Fetches all roles")
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> roles = validationService.fetchRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
}
