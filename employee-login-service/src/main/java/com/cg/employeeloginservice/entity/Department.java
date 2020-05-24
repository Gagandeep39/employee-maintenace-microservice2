/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 18:16:52
 * @modify date 2020-05-05 18:16:52
 * @desc Department Details
 */
package com.cg.employeeloginservice.entity;

import lombok.*;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "department_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@ApiModel("Department - Stores the department")
public class Department {

    /**
     * Department ID
     * Uses a sequence generator named dept_id_sequence"
     * Initial value is 100000
     */
    @Id
    @SequenceGenerator(name = "dept_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "dept_id_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "dept_id", length = 6)
    @ApiModelProperty("Department ID")
    private Integer departmentId;

    /**
     * Department Name
     */
    @Column(name = "dept_name", length = 25)
    @ApiModelProperty("Department Name")
    private String departmentName;

}
