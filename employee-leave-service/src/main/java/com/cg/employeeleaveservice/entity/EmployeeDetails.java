/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 17:32:19
 * @modify date 2020-05-05 17:32:19
 * @desc Storing User details
 */
package com.cg.employeeleaveservice.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.employeeleaveservice.enums.Gender;
import com.cg.employeeleaveservice.enums.Grade;
import com.cg.employeeleaveservice.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Table Name - Employee Details
 * @Getter - Generates getters
 * @Setter - Generates Setter
 * @ToString - Overrides default string behviour
 */
@Entity
@Table(name = "emp_details")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"user", "address", "manager", "subEmployees"})
@ApiModel("Employee details : Stores the employee details after registering by admin")
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class EmployeeDetails {

    /**
     * Employee ID - Primary Key
     */
    @Id
    @Column(name = "emp_details_id")
    @ApiModelProperty("Employee ID")
    private Integer empDetailsId;

    /**
     * First name
     */
    @Column(name = "first_name", length = 20)
    @ApiModelProperty("First name")
    private String firstName;

    /**
     * Last name
     */
    @Column(name = "last_name", length = 20)
    @ApiModelProperty("Last name")
    private String lastName;

    /**
     * Date of Birth
     */
    @Column(name = "date_of_birth")
    @ApiModelProperty("Date of birth")
    private LocalDate dateOfBirth;

    /**
     * Date of Joining
     */
    @Column(name = "date_of_joining")
    @ApiModelProperty("Date of joining")
    private LocalDate dateOfJoining;

    /**
     * Email ID
     */
    @Column(name = "email", length = 50)
    @ApiModelProperty("Email id")
    private String email;

    /**
     * Phone number
     */
    @Column(name = "phoneno", length = 10)
    @ApiModelProperty("Phone number")
    private String phoneNumber;

    /**
     * Marital Status - Based on Enum Value
     */
    @Column(name = "marital_status", length = 10)
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Marital status")
    private MaritalStatus maritalStatus;
    
    /**
     * Genders
     */
    @Column(name = "gender", length = 1)
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Gender")
    private Gender gender;

    /**
     * Grade - (M1, M2.....M7)
     */
    @Column(name = "emp_grade", length = 2)
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Grade")
    private Grade grade;

    /**
     * Basic Salary
     */
    @Column(name = "emp_basic")
    @ApiModelProperty("Basic salary")
    private Double basic;

    /**
     * Designation
     */
    @Column(name = "designation", length = 25)
    @ApiModelProperty("Designation")
    private String designation;

    /**
     * Mapping to department 
     * Requires a department foreign key
     */
    @ManyToOne
    @JoinColumn(name = "dept_id", foreignKey = @ForeignKey(name = "FK_DEPT_ID"))
    @ApiModelProperty("Department object")
    private Department department;

    /**
     * One to one mapping with address
     */
    @OneToOne(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
    @ApiModelProperty("Address object")
    private Address address;

    /**
     * Back reference to user cedential table 
     * Maps rimary key of current entity with parents primary key
     * JsonBackReference - Implies this is the child entity
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    @JsonBackReference
    @MapsId
    @ApiModelProperty("User object")
    private User user;

    /**
     * Manager Mapping
     * Multiple Employees have same manager
     * @JsonIdentityInfo  -Prevents recursive self looping
     * @JsonIdentityReference - Replaces Manager object with manager ID
     */
    @ManyToOne
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_MANAGER_EMP_ID"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empDetailsId")
    @JsonIdentityReference(alwaysAsId = true)
    @ApiModelProperty("Manager object")
    private EmployeeDetails manager;

    /**
     * Stores a list of Employees that are associated with current employee object
     */
    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    @ApiModelProperty("List of sub employees")
    private List<EmployeeDetails> subEmployees = new ArrayList<>();

    /**
     * Leave History of the Employyee
     * @JsonIgnore impleies that tis data is not required to be fecthed with employee
     */
    @JsonIgnore
    @OneToMany(mappedBy = "employeeDetails")
    @ApiModelProperty("Set of leave histories")
    private Set<LeaveHistory> leaveHistories = new HashSet<>();

    public void addLeave(LeaveHistory leaveHistory){
        leaveHistories.add(leaveHistory);
    }

    public void removeLeave(Integer leaveId){
        leaveHistories.removeIf(leaveHistory -> leaveHistory.getLeaveId().equals(leaveId));
    }

}
