package com.cg.employeeleaveservice.service;

import com.cg.employeeleaveservice.entity.LeaveHistory;
import org.springframework.data.domain.Page;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 12:01
 */
public interface LeaveService {

    /**
     * Create  a new Leave
     * @param leaveHistory Leave data to be added in a database
     * @param empId Id of employee whose leave is to be created
     * @return A leave Object with ID provided by Databsae
     */
    LeaveHistory createLeave(LeaveHistory leaveHistory, Integer empId);

    /**
     * Update Lave history
     * @param leaveHistory Stores data of leave to be updated
     * @return An updated leave Object
     */
    LeaveHistory updateLeave(LeaveHistory leaveHistory);

    /**
     * ***NOT Used anywhere
     * Fetch Leave of ALl Employees
     * @param pageNo The page number to be fetched
     * @param pageSize No. of elements in each page
     * @param sortBy Field by whuch data is to be orted
     * @param empId Id of employee whose leaves is to be fetched
     * @return A LeaveHistory Page
     */
    Page<LeaveHistory> fetchAllEmployeeLeave(Integer pageNo, Integer pageSize, String sortBy, Integer empId);
    
    /**
     * Fetch Leave of ALl Employees
     * @param pageNo The page number to be fetched
     * @param pageSize No. of elements in each page
     * @param sortBy Field by whuch data is to be orted
     * @param managerId Id of manager whose subemploye leaves are to be fetched
     * @return A LeaveHistory Page
     */
    Page<LeaveHistory> fetchAllSubEmployeeLeaves(Integer pageNo, Integer pageSize, String sortBy, Integer managerId);

    /**
     * Feth leave balcne of an Employee
     * @param empId Id of An Employee
     * @return Leave balance of AN Employee
     */
    Integer fetchLeaveBalance(Integer empId);

    /**
     * A scheduled task to automtically approve leave
     */
    void scheduledUpdate();


}
