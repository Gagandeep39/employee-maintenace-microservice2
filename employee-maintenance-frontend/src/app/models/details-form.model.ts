import { MaritalStatus } from './marital-status.model';
import { Gender } from './gender.model';
import { Department } from './department.model';
import { Grade } from './grade.model';
import { ManagerDetailsForm } from './manager-form.model';
import { Address } from './address.model';

export class UserDetailsFrom {
        empDetailsId: number;
        firstName: string;
        lastName: string;
        dateOfBirth: Date;
        dateOfJoining: Date;
        maritalStatus: MaritalStatus;
        gender: Gender;
        department: Department
        manager: ManagerDetailsForm;
        grade: Grade;
        designation: string;
        basic: number;
        phoneNumber: string;
        email: string;
        address: Address;
}