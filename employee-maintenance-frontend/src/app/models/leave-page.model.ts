/*
 @author Pranav Karmarkar
*/

import { Sort } from './sort.model';
import { LeaveHistory } from './leave-history.model';

export class LeavePage {
    content:          LeaveHistory[];
    last:             boolean;
    totalPages:       number;
    totalElements:    number;
    size:             number;
    number:           number;
    sort:             Sort;
    first:            boolean;
    numberOfElements: number;
    empty:            boolean;
}