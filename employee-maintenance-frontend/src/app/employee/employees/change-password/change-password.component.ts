import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CustomValidators } from 'src/app/shared/custom-validators';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';
import { User } from 'src/app/models/user.mode';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  changePasswordForm: FormGroup;
  submitted = false;
  isLoading = false;
  errorMessage: string;
  user: User = new User();
  referenceMessage: string;

  constructor(private router: Router, private employeeService: EmployeeService, private authService : AuthService) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.changePasswordForm = new FormGroup(
      {
        oldPassword: new FormControl('', [
          Validators.required,
          CustomValidators.validateOldPassword
        ]),
        password: new FormControl('', [
          Validators.required,
          Validators.pattern(
            '^(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}$'
          ),
          Validators.minLength(6),
        ]),
        confirmPassword: new FormControl('', [
          Validators.required,
          Validators.pattern(
            '^(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}$'
          ),
        ]),
        
      },
      { validators: CustomValidators.matchPassword }
    );
  }

  
  onSubmit() {
    this.submitted = true;
    if (this.changePasswordForm.valid) {
      this.showLoading();
      delete this.changePasswordForm.value.confirmPassword;
      this.authService.changePassword(this.changePasswordForm.value)
      .subscribe(response => {
        this.hideLoading();
        this.referenceMessage = 'Successfully Changed password'
        setTimeout(()=>this.router.navigate(['/employee/home']), 4000)
      }, error => this.handleError(error))
      
    }
  }

  handleError(error: any): void {
    this.hideLoading();
    this.errorMessage = 'Error Commnicatig to server';
    console.log(error);
    
    setTimeout(()=>this.errorMessage = undefined, 4000)
  }

  showLoading() {
    this.isLoading = true;
  }

  hideLoading() {
    this.isLoading = false;
  }
}
