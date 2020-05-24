/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 22:43:02
 * @modify date 2020-05-09 22:43:02
 * @desc Employee Details
 */

import { Department } from './department.model';
import { Address } from './address.model';

export class EmployeeDetails {
    empDetailsId:  number;
    firstName:     string;
    lastName:      string;
    dateOfBirth:   Date;
    dateOfJoining: Date;
    email:         string;
    phoneNumber:   string;
    maritalStatus: string;
    gender:        string;
    grade:         string;
    basic:         number;
    designation:   string;
    department:    Department;
    address:       Address;
    manager:       number;
}