import { Pipe, PipeTransform } from '@angular/core';
import { Grade } from '../models/grade.model';

@Pipe({
  name: 'gradeType'
})
export class GradeTypePipe implements PipeTransform {

  transform(value: Grade, args?: any): any {
    return value.gradeCode + ' (₹' + value.minSalary + ' - ₹' + value.maxSalary + ')';
  }

}
