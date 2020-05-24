/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 09:45:01
 * @modify date 2020-05-11 09:45:01
 * @desc User Information
 */

import { Role } from './role.model';
import { UserDetailsFrom } from './details-form.model';

export class UserForm {
    username: string;
    password: string;
    role: Role;
    employeeDetails: UserDetailsFrom;
}
