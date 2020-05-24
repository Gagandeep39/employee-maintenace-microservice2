/* 
@author Pranav Karmarkar
*/
package com.cg.employeevalidationservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "manager")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel("Manager : Stores ID and name of managers")
public class Manager {

	@Id
    @Column(name = "manager_id")
    @ApiModelProperty("Manager ID")
    private Integer managerId;

    @Column(name = "first_name")
    @ApiModelProperty("First name")
    private String firstName;

    @Column(name = "last_name")
    @ApiModelProperty("Last name")
    private String lastName;
}
