/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-12 12:37:04
 * @modify date 2020-05-12 12:37:04
 * @desc Approve Leaves every day
 */
package com.cg.employeeleaveservice.schedulingtask;

import java.util.Date;

import com.cg.employeeleaveservice.service.LeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * A schedling task to approve leaves
 */
@Component
@Slf4j
public class ApproveLeaveScheduler {

    @Autowired
    private LeaveService leaveService;

    /**
     * Executed every day at 11:00 pm
     * Uses CRON Standard
     * second, mind, hour, day, week, month
     */
    @Scheduled(cron = "0 0 23 * * *")
    public void autoApproveLeave() {
        leaveService.scheduledUpdate();
        log.info("Executed at " + new Date());
    }
    
}