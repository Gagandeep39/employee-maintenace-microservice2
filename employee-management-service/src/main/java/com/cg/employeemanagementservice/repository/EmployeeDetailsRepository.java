package com.cg.employeemanagementservice.repository;

import com.cg.employeemanagementservice.enums.Gender;
import com.cg.employeemanagementservice.enums.Grade;
import com.cg.employeemanagementservice.enums.MaritalStatus;
import com.cg.employeemanagementservice.entity.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:35
 */

/**
 * Repository clas to fetch data
 */
@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

    /**
     * Fetch By gender
     * @param genders List of genders for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching gender
     */
    Page<EmployeeDetails> findByGenderIn(Collection<Gender> genders, Pageable pageable);

    /**
     * Fetch By gender
     * @param department List of department for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching gdepartment
     */
    Page<EmployeeDetails> findByDepartment_DepartmentNameIn(Collection<String> department, Pageable pageable);

    /**
     * Fetch By maritalStatuses
     * @param maritalStatuses List of maritalStatuses for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching maritalStatuses
     */
    Page<EmployeeDetails> findByMaritalStatusIn(Collection<MaritalStatus> maritalStatuses, Pageable pageable);

    /**
     * Fetch By grade
     * @param grade List of grade for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching grade
     */
    Page<EmployeeDetails> findByGradeIn(Collection<Grade> grade, Pageable pageable);

    /**
     * Fetch By managerId
     * @param managerId managerId for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching managerId
     */
    Page<EmployeeDetails> findByManager_EmpDetailsId(Integer managerId, Pageable pageable);

    /**
     * Fetch By Name
     * @param firstName List of firstName for mathing
     * @param lastName List of lastName for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching name
     */
    Page<EmployeeDetails> findEmployeeDetailsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable);

            /**
     * Fetch By firstName
     * @param firstName List of firstName for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching firstName
     */
    Page<EmployeeDetails> findEmployeeDetailsByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);

    /**
     * Fetch By lastName
     * @param lastName List of lastName for mathing
     * @param pageable Page meta data
     * @return Page of Employee with matching lastName
     */
    Page<EmployeeDetails> findEmployeeDetailsByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}
