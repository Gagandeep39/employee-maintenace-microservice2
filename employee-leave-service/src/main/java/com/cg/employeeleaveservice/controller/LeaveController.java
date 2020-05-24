package com.cg.employeeleaveservice.controller;

import com.cg.employeeleaveservice.entity.LeaveHistory;
import com.cg.employeeleaveservice.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 12:12
 */

@RestController
@CrossOrigin("*")
@Api("Manage leave related operations")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    /**
     * Fetch all Leave of An Employee
     */
    @GetMapping("/leaves/employee/{empId}")
    @ApiOperation(value = "Fetches all leaves of the employee")
    public ResponseEntity<Page<LeaveHistory>> fetchEmployeeLeave(
            @PathVariable Integer empId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "leaveId") String sortBy){
        Page<LeaveHistory> leaveHistories = leaveService.fetchAllEmployeeLeave(pageNo, pageSize, sortBy, empId);
        return new ResponseEntity<>(leaveHistories, HttpStatus.OK);
    }

    /**
     * Fetch All manager leaves
     */
    @GetMapping("/leaves/manager/{managerId}")
    @ApiOperation(value = "Fetches all sub employee leaves of manager")
    public ResponseEntity<Page<LeaveHistory>> fetchManagerLeaves(
            @PathVariable Integer managerId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "leaveId") String sortBy){
        Page<LeaveHistory> leaveHistories = leaveService.fetchAllSubEmployeeLeaves(pageNo, pageSize, sortBy, managerId);
        return new ResponseEntity<>(leaveHistories, HttpStatus.OK);
    }

    /**
     * Crate a new Lave
     */
    @PostMapping("/leaves/{empId}")
    @ApiOperation(value = "Adds new leave into system")
    public ResponseEntity<LeaveHistory> addLeave(
        @PathVariable Integer empId, 
        @RequestBody LeaveHistory leaveHistory){
        LeaveHistory updatedLeaveHistory = leaveService.createLeave(leaveHistory, empId);
        return new ResponseEntity<>(updatedLeaveHistory, HttpStatus.ACCEPTED);
    }

    /**
     * Update :Leave
     */
    @PutMapping("/leaves")
    @ApiOperation(value = "Updates leave status in system")
    public ResponseEntity<LeaveHistory> updateLeave(@RequestBody LeaveHistory leaveHistory){
        LeaveHistory updatedLeaveHistory = leaveService.updateLeave(leaveHistory);
        return new ResponseEntity<>(updatedLeaveHistory, HttpStatus.ACCEPTED);
    }

    /**
     * Fteh leave Balance
     */
    @GetMapping("/leaves/balance/{empId}")
    @ApiOperation(value = "Fetches leave balance of employee")
    public ResponseEntity<HashMap<String, Integer>> fetchBalance(@PathVariable Integer empId){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("balance", leaveService.fetchLeaveBalance(empId));
        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
    }

}
