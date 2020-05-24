package com.cg.employeeloginservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gagandeep
 * @date 13-05-2020
 * @time 22:50
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ChangePassword {

    private Integer userId;
    private String oldPassword;
    private String password;

}
