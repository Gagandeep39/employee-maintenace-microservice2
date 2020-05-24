import { Pipe, PipeTransform } from '@angular/core';
import { Manager } from '../models/manager.model';

@Pipe({
  name: 'managerInfo'
})
export class ManagerInfoPipe implements PipeTransform {

  transform(value: Manager, args?: any): any {
    return value.managerId + ' - ' + value.firstName + ' ' + value.lastName;
  }

}
