package com.cg.employeeleaveservice.service.implementation;

import com.cg.employeeleaveservice.enums.LeaveStatus;
import com.cg.employeeleaveservice.exception.LeaveNotFoundException;
import com.cg.employeeleaveservice.entity.EmployeeDetails;
import com.cg.employeeleaveservice.entity.LeaveHistory;
import com.cg.employeeleaveservice.repository.LeaveHistoryRepository;
import com.cg.employeeleaveservice.service.LeaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 12:03
 */

@Service
@Slf4j
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveHistoryRepository leaveHistoryRepository;

    @Override
    public LeaveHistory createLeave(LeaveHistory leaveHistory, Integer empId) {
        EmployeeDetails details = new EmployeeDetails();
        details.setEmpDetailsId(empId);
        leaveHistory.setEmployeeDetails(details);
        leaveHistory.setLeaveBalance(fetchLeaveBalance(empId));
        leaveHistory.setLeaveStatus(LeaveStatus.Applied);
        Period period = Period.between(leaveHistory.getDateFrom(), leaveHistory.getDateTo());
        leaveHistory.setNumberOfDays(period.getDays() + 1);
        log.info("Days: " + leaveHistory.toString());
        return leaveHistoryRepository.save(leaveHistory);
    }

    @Override
    public LeaveHistory updateLeave(LeaveHistory leaveHistory) {
        Optional<LeaveHistory> container = leaveHistoryRepository.findById(leaveHistory.getLeaveId());
        container.orElseThrow(() -> new LeaveNotFoundException("Leave not found"));
        LeaveHistory tempHistory = container.get();
        if (tempHistory.getLeaveStatus()== LeaveStatus.Approved)
            throw new RuntimeException("Leave Already Approved");
        if (leaveHistory.getLeaveStatus().equals(LeaveStatus.Rejected))
            return rejectLeave(tempHistory);
        else
            return approveLeave(tempHistory);
    }

    private LeaveHistory approveLeave(LeaveHistory tempLeave) {
        Integer count = tempLeave.getNumberOfDays();
        Integer balance = tempLeave.getLeaveBalance();
        int updatedBalance = balance - count;
        if(updatedBalance<0)
            throw new RuntimeException("Out of Leave Balance");
        Integer empId = tempLeave.getEmployeeDetails().getEmpDetailsId();
        leaveHistoryRepository.updateLeaveBalance(empId, updatedBalance);
        tempLeave.setLeaveStatus(LeaveStatus.Approved);
        tempLeave.setLeaveBalance(updatedBalance);
        return leaveHistoryRepository.save(tempLeave);
    }

    private LeaveHistory rejectLeave(LeaveHistory tempLeave) {
        tempLeave.setLeaveStatus(LeaveStatus.Rejected);
        return leaveHistoryRepository.save(tempLeave);
    }

    @Override
    public Page<LeaveHistory> fetchAllEmployeeLeave(Integer pageNo, Integer pageSize, String sortBy, Integer empId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return leaveHistoryRepository.findByEmployeeDetails_EmpDetailsId(paging, empId);
    }

    @Override
    public Page<LeaveHistory> fetchAllSubEmployeeLeaves(Integer pageNo, Integer pageSize, String sortBy, Integer managerId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return leaveHistoryRepository.findByEmployeeDetails_Manager_EmpDetailsId(managerId, paging);
    }

    @Override
    public Integer fetchLeaveBalance(Integer empId) {
        Pageable paging = PageRequest.of(0, 1);
        Page<LeaveHistory> pages = leaveHistoryRepository.findByEmployeeDetails_EmpDetailsId(paging, empId);
        if (pages.getContent().isEmpty())
            return 13;
        return pages.getContent().get(0).getLeaveBalance();
    }

    @Override
    public void scheduledUpdate() {
        leaveHistoryRepository.scheduledUpdate();
    }
}
