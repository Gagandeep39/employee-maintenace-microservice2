/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 02:08:08
 * @modify date 2020-05-11 02:08:08
 * @desc [description]
 */
import {
  FormControl,
  ValidatorFn,
  AsyncValidatorFn,
  ValidationErrors,
  FormGroup,
} from '@angular/forms';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { ValidatorService } from '../service/validator.service';
import { Grade } from '../models/grade.model';
import { User } from '../models/user.mode';

export class CustomValidators {
  static forbiddenAge(control: FormControl) {
    const dob = new Date(control.value);
    const today = new Date();
    const diff = today.getFullYear() - dob.getFullYear();

    if (diff < 18 || diff > 58) {
      return { ageIsForbidden: true };
    }
    return null;
  }

  static forbidFutureDate(control: FormControl) {
    const dob = new Date(control.value);
    if (dob > new Date()) {
      return { futureDateForbidden: true };
    }
    return null;
  }

  static forbiddenSalary(grade: Grade): ValidatorFn {
    return (control: FormControl): ValidationErrors | null => {
      const currentSal = +control.value;
      if (currentSal < grade.minSalary || currentSal > grade.maxSalary) {
        return { salaryIsForbidden: true };
      }
      return null;
    };
  }

  static matchPassword(control: FormControl) {
    const password = control.get('password').value;
    const confirmPassword = control.get('confirmPassword').value;
    if (password != confirmPassword) {
      control.get('confirmPassword').setErrors({ passwordMatchError: true });
    } else {
      return null;
    }
  }

  static usernameValidator(service: ValidatorService) {
    return (control: FormControl) => {
      return service
        .validateUser(control.value)
        .pipe(map((response) => (response ? null : { usernameTaken: true })));
    };
  }

  static cannotBePastDate() {
    return (control: FormControl) => {
      const dateFrom: Date = control.get('dateFrom').value;
      const from = new Date(dateFrom);
      if (from < new Date())
          control.get('dateFrom').setErrors({ previousDate: true });
      else 
        return null;
    };
  }

  static validateBalance(leaveBalance: number) {
    return (control: FormControl) => {
      const from = new Date(control.get('dateFrom').value);
      const to = new Date(control.get('dateTo').value);
      const diff = to.getDate() - from.getDate();
      if (leaveBalance - diff < 0)
        control.get('dateTo').setErrors({ insufficientBalance: true });
      else return null;
    };
  }

  static dateLessThan(from: string, to: string) {
    return (group: FormGroup): { [key: string]: any } => {
      let f = group.controls[from];
      let t = group.controls[to];
      if (f.value > t.value) {
        group.controls[to].setErrors({dateToLessThanFrom: true})
      }
      return {};
    };
  }

  static validateOldPassword(control: FormControl) {
    const oldPassword: string = control.value;
    let user: User = JSON.parse(sessionStorage.getItem('user'));
    if (oldPassword != user.password) {
      return { incorrectPassword: true };
    return null;
  }
}
}
