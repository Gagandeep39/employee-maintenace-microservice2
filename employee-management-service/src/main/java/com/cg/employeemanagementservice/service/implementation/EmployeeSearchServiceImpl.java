package com.cg.employeemanagementservice.service.implementation;

import com.cg.employeemanagementservice.enums.Gender;
import com.cg.employeemanagementservice.enums.Grade;
import com.cg.employeemanagementservice.enums.MaritalStatus;
import com.cg.employeemanagementservice.entity.EmployeeDetails;
import com.cg.employeemanagementservice.repository.EmployeeDetailsRepository;
import com.cg.employeemanagementservice.service.EmployeeSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 03:12
 */

@Service
@Slf4j
public class EmployeeSearchServiceImpl implements EmployeeSearchService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Override
    public Page<EmployeeDetails> findEmployeeByManagerId(Integer pageNo, Integer pageSize, String sortBy, Integer managerId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findByManager_EmpDetailsId(managerId, paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findAll(paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findByGenders(Integer pageNo, Integer pageSize, String sortBy, String genders) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        List<Gender> genderList = Arrays.stream(genders.split(","))
                .map(Gender::valueOf)
                .collect(Collectors.toList());;
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findByGenderIn(genderList, paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findByMaritalStatuses(Integer pageNo, Integer pageSize, String sortBy, String maritalStatuses) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        List<MaritalStatus> maritalStatusList = Arrays.stream(maritalStatuses.split(","))
                .map(MaritalStatus::valueOf)
                .collect(Collectors.toList());;
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findByMaritalStatusIn(maritalStatusList, paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findByDepartments(Integer pageNo, Integer pageSize, String sortBy, String departments) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<String> departmentList = Arrays.asList(departments.split(","));
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findByDepartment_DepartmentNameIn(departmentList, paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findByGrade(Integer pageNo, Integer pageSize, String sortBy, String grades) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        List<Grade> gradeList = Arrays.stream(grades.split(","))
                .map(Grade::valueOf)
                .collect(Collectors.toList());
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findByGradeIn(gradeList, paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findByName(Integer pageNo, Integer pageSize, String sortBy, String name) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findEmployeeDetailsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name, paging);
        return pagedResult;
    }

    @Override
    public EmployeeDetails findById(Integer id) {
        return employeeDetailsRepository.findById(id).get();
    }

    @Override
    public Page<EmployeeDetails> findByFirstName(Integer pageNo, Integer pageSize, String sortBy, String firstName) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findEmployeeDetailsByFirstNameContainingIgnoreCase(firstName, paging);
        return pagedResult;
    }

    @Override
    public Page<EmployeeDetails> findByLastName(Integer pageNo, Integer pageSize, String sortBy, String lastName) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeDetails> pagedResult = employeeDetailsRepository.findEmployeeDetailsByLastNameContainingIgnoreCase(lastName, paging);
        return pagedResult;
    }

}
