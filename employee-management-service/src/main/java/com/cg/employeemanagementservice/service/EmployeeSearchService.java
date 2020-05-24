package com.cg.employeemanagementservice.service;

import com.cg.employeemanagementservice.entity.EmployeeDetails;
import org.springframework.data.domain.Page;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 03:08
 */

/**
 * Perform Filter based Based search on EMployee Detail
 */
public interface EmployeeSearchService {

    /**
     * 
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute by which data will be sorted
     * @param managerId Manager ID by which EMployee will be fetched
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findEmployeeByManagerId(Integer pageNo, Integer pageSize, String sortBy, Integer managerId);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute by which data will be sorted
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
    /**
     * Fetch All Employees By Gender
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute by which data will be sorted
     * @param genders Gender by Whcih data will be fetced
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findByGenders(Integer pageNo, Integer pageSize, String sortBy, String genders);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param maritalStatuses Marital Status by Whcih data will be fetced
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findByMaritalStatuses(Integer pageNo, Integer pageSize, String sortBy, String maritalStatuses);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param departments Department name by which data will be fetched
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findByDepartments(Integer pageNo, Integer pageSize, String sortBy, String departments);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param grades Grades by Whcih data will be fetced
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findByGrade(Integer pageNo, Integer pageSize, String sortBy, String grades);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param name Name throug which data will be fetched
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findByName(Integer pageNo, Integer pageSize, String sortBy, String name);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param id Fetch a single Employee By ID
     * @return A page containing Employee
     */
    EmployeeDetails findById(Integer id);

    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param firstName Fist name through Whcih data will be fetced
     * @return A page containing Employee
     */
	Page<EmployeeDetails> findByFirstName(Integer pageNo, Integer pageSize, String sortBy, String firstName);
    
    /**
     * Fetch All Employees
     * @param pageNo The page number tob e fetched
     * @param pageSize No. Of elemts in each page
     * @param sortBy Atribute b  which data will be sorted
     * @param lastName by Whcih data will be fetced
     * @return A page containing Employee
     */
    Page<EmployeeDetails> findByLastName(Integer pageNo, Integer pageSize, String sortBy, String lastName);

}
