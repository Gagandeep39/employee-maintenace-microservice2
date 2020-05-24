/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 19:07:53
 * @modify date 2020-05-11 19:07:53
 * @desc Create Leave
 */
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl,
} from '@angular/forms';
import { ValidatorService } from 'src/app/service/validator.service';
import { LeaveService } from 'src/app/service/leave.service';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { CustomValidators } from 'src/app/shared/custom-validators';

@Component({
  selector: 'app-create-leave',
  templateUrl: './create-leave.component.html',
  styleUrls: ['./create-leave.component.css'],
})
export class CreateLeaveComponent implements OnInit {
  form: FormGroup;
  submitted: boolean = false;
  leaveBalance: number = 13;
  leaveButtonEnabled: boolean = true;
  errorMessage: string;
  isLoading: boolean = false;

  constructor(
    private fb: FormBuilder,
    private leaveService: LeaveService,
    private router: Router
  ) {
    this.createForm();
  }

  ngOnInit(): void {
    this.showLoading();
    this.leaveService.getLeaveBalance().subscribe(
      (response) => {
        this.leaveBalance = response;
        this.hideLoading();
      },
      (error) => {
        this.leaveButtonEnabled = false;
        this.handleError(error);
      }
    );
  }

  createForm() {
    this.form = this.fb.group(
      {
        dateFrom: ['', Validators.required],
        dateTo: ['', Validators.required],
      },
      {
        validator: [
          CustomValidators.dateLessThan('dateFrom', 'dateTo'),
          CustomValidators.cannotBePastDate(),
          CustomValidators.validateBalance(this.leaveBalance),
        ],
      }
    );
  }

  onSubmit() {
    this.showLoading();
    this.submitted = true;
    if (this.form.valid) {
      this.leaveService.createLeave(this.form.value).subscribe(
        (response) => {
          this.hideLoading();
          this.router.navigate(['/employee/leaves']);
        },
        (error) => {
          this.handleError(error);
        }
      );
    }
  }

  handleError(error: string) {
    this.errorMessage = 'Something went wrong :(';
    console.log(error);
    this.hideLoading();
    setTimeout(() => {
      this.errorMessage = undefined;
      this.leaveButtonEnabled = true;
    }, 4000);
  }

  showLoading() {
    this.isLoading = true;
  }

  hideLoading() {
    this.isLoading = false;
  }
}
