/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 22:40:47
 * @modify date 2020-05-09 22:40:47
 * @desc User Model
 */

import { EmployeeDetails } from './employee-details.model';
import { Role } from './role.model';

export class User {
    empId:           number;
    username:        string;
    password:        string;
    role:            Role;
    employeeDetails: EmployeeDetails;
}
