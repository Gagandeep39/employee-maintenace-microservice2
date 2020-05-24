/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 18:33:35
 * @modify date 2020-05-06 18:33:35
 * @desc Employees adress details
 */
package com.cg.employeemanagementservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Table - A table with the entity structure will be created
 * @Getter - Creates getters
 * @Setter - Creates Setter Objectss
 * @NoArgsConstuctor - Creates a no argument constructor
 * @ToString - Overrides default string behaviour
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"employeeDetails"})
@ApiModel("Address - Stores address of the employee")
public class Address {

    /**
     * Primary KKey
     * Column Name - Address ID
     * Json Ignore - To prevent this Id from being sent in response as its same as parent Employee
     */
    @Id
    @Column(name = "address_id")
    @JsonIgnore
    @ApiModelProperty("Address ID")
    private Integer addressId;

    /**
     * Column City
     */
    @ApiModelProperty("City")
    @Column(length = 25)
    private String city;

    /**
     * Column State
     */
    @ApiModelProperty("State")
    @Column(length = 25)
    private String state;

    /**
     * Column Area
     */
    @ApiModelProperty("Area")
    @Column(length = 25)
    private String area;

    /**
     * Column Pincode
     */
    @ApiModelProperty("Pin code")
    @Column(length = 6)
    private String pincode;

    /**
     * Maps ID with parent Object i.e same as Emplolyee Details
     * Can be cosidered as a back link
     */
    @MapsId
    @OneToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_Address_EMP_ID"))
    @JsonBackReference
    @ApiModelProperty("Back link to employee details")
    private EmployeeDetails employeeDetails;

}
