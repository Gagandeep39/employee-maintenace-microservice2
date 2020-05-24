/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 18:18:30
 * @modify date 2020-05-05 18:18:30
 * @desc Grade Details
 */
package com.cg.employeevalidationservice.entity;

import lombok.*;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Creates a grade table
 */
@Entity
@Table(name = "grade_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("Grade : Stores the grade details")
public class Grade {

    /**
     * Uses a manually createde sequece named 'grade_code_sequence'
     * Stores grade related Information
     * Used to validate the grade to take input by the user
     */
    @Id
    @SequenceGenerator(name = "grade_code_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "grade_code_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "grade_code", length = 2)
    @ApiModelProperty("Grade code")
    private String gradeCode;

    /**
     * Minimum salary for this grade
     */
    @Column(name = "grade_min_sal", length = 6)
    @ApiModelProperty("Minimum salary")
    private Double minSalary;

    /**
     * Maximum salary fir thhe specific grade
     */
    @Column(name = "grade_max_sal", length = 6)
    @ApiModelProperty("Maximum salary")
    private Double maxSalary;

    /**
     * Grade description
     */
    @Column(name = "grade_desc", length = 100)
    @ApiModelProperty("Description")
    private String description;

}
