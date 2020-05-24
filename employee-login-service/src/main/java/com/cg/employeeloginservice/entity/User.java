/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 17:18:24
 * @modify date 2020-05-05 17:18:24
 * @desc Basic user Credential
 */
package com.cg.employeeloginservice.entity;

import com.fasterxml.jackson.annotation.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Parent class that stores user credentials
 */
@Entity
@Table(name = "user_master")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel("User : Stores the user details")
//@ToString(exclude = {"employeeDetails"})
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class User {

    /**
     * Primary Key
     * Manual Sequnce generator
     */
    @Id
    @Column(name = "user_id", nullable = false)
    @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    @ApiModelProperty("Employee ID")
    private Integer empId;

    /**
     * Username
     */
    @Column(name = "username", length = 20, unique = true)
    @ApiModelProperty("Username")
    private String username;

    /**
     * Password
     */
    @Column(name = "password", length = 20)
    @ApiModelProperty("Password")
    private String password;

    /**
     * Multiple Employees can have same role
     */
    @ManyToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_role_id"))
    @ApiModelProperty("Role ID")
    private Role role;

    /**
     * Paret side in  parent child relationship
     * Bi directional mapping
     */
    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.MERGE)
    @ApiModelProperty("Link to employee details")
    private EmployeeDetails employeeDetails;

}
