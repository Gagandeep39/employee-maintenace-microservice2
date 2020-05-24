package com.cg.employeeloginservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cg.employeeloginservice.enums.LeaveStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 19:54
 */

 /**
  * Creates a grade table
  */
@Entity
@Table(name = "leave_history")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employeeDetails")
@ApiModel("Leave history : Stores the history of leaves of employee")
public class LeaveHistory {

    /**
     * Manual sequence generator for leave hostory
     * Starting value is 100000
     */
    @Id
    @Column(name = "leave_id")
    @SequenceGenerator(name = "leave_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "leave_id_sequence", strategy = GenerationType.SEQUENCE)
    @ApiModelProperty("Leave ID")
    private Integer leaveId;

    /**
     * Leave Balance
     */
    @Column(name = "leave_balance")
    @ApiModelProperty("Leave balance")
    private Integer leaveBalance;

    /**
     * Date from
     */
    @Column(name = "date_from")
    @ApiModelProperty("Leave from date")
    private LocalDate dateFrom;

    /**
     * Date TO
     */
    @Column(name = "date_to")
    @ApiModelProperty("Leave to date")
    private LocalDate dateTo;

    /**
     * Leave Status
     */
    @Column(name = "leave_status", columnDefinition = "varchar(20) check (leave_status in ('Applied','Approved','Rejected'))")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Leave status")
    private LeaveStatus leaveStatus;

    /**
     * Number of days he eave was requested for
     */
    @Column(name = "no_of_days_applied")
    @ApiModelProperty("Number of days for which leave is applied")
    private Integer numberOfDays;

    /**
     * Maping with Employee
     * Multiple Leaves ca be taken buy a single Employee
     */
    @ManyToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_LEAVE_ID"))
    // @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empDetailsId")
    @JsonIdentityReference(alwaysAsId = true)
    @ApiModelProperty("Link to employee details")
    private EmployeeDetails employeeDetails;
    
    /**
     * Createion time i.e Time when this leave was created
     */
    @Column(name = "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    @ApiModelProperty("Creation time of leave")
    private LocalDateTime creationTime;

}
