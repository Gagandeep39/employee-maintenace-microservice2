package com.cg.employeeleaveservice.repository;

import com.cg.employeeleaveservice.entity.LeaveHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 09:13
 */

@Repository
@Transactional
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, Integer> {

    /**
     * Fetch Leave history of an EMployee
     * @param pageable The page meta data to fetch pages
     * @param empId Id of Employee whose leave history is to be fetched
     * @return Page containing leave Histories
     */
    Page<LeaveHistory> findByEmployeeDetails_EmpDetailsId(Pageable pageable, Integer empId);

    /**
     * Fetch manager Leaves By ID
     * @param managerId Id of manager whose subemployees are to be fetched
     * @param pageable The page meta data to fetch pages
     * @return Page containing leave Histories
     */
    Page<LeaveHistory> findByEmployeeDetails_Manager_EmpDetailsId(Integer managerId, Pageable pageable);

    /**
     * Update the leave balance Manually
     * @param empId Id of EMplloyee Whose leave balance is to be updated
     * @param updatedBalance Balnce by which the database balance is to be updated
     */
    @Modifying
    @Query("update LeaveHistory l set l.leaveBalance=?2 where l.employeeDetails.empDetailsId=?1")
    void updateLeaveBalance(Integer empId, Integer updatedBalance);

    /**
     * Update the Lave status to approved and rduce the leave balance
     * Uses native Query
     */
    @Modifying
    @Query(value = "update leave_history set leave_status='Approved', leave_balance=leave_balance-no_of_days_applied where leave_status='Applied' AND leave_id in (select  leave_id from leave_history l where TIMESTAMPDIFF(second,l.created_on,NOW()) >259200)", nativeQuery = true)
    void scheduledUpdate();

}
