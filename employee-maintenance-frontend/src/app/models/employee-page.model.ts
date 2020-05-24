import { EmployeeDetails } from './employee-details.model';
import { Sort } from './sort.model';

export class EmployeePage {
    content:          EmployeeDetails[];
    totalPages:       number;
    last:             boolean;
    totalElements:    number;
    size:             number;
    number:           number;
    sort:             Sort;
    numberOfElements: number;
    first:            boolean;
    empty:            boolean;
}