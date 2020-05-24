import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomValidators } from 'src/app/shared/custom-validators';
import { User } from 'src/app/models/user.mode';
import { RoleType } from 'src/app/models/role-type.model';
import { EmployeeService } from 'src/app/service/employee.service';
import { ValidatorService } from 'src/app/service/validator.service';
import { UserForm } from 'src/app/models/user-form.model';
import { Role } from 'src/app/models/role.model';
import { HttpHandler } from '@angular/common/http';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
})
export class AddUserComponent implements OnInit {
  // Form object to access form values
  userRegisterationForm: FormGroup;
  // Boolean value to know whether form is submitted
  submitted = false;
  roles: Role[] = [];
  isLoading = false;
  errorMessage: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private validatorService: ValidatorService
  ) {}
  ngOnInit() {
    this.fetchRoles();
    this.initForm();
  }

  fetchRoles() {
    this.showLoading();
    this.validatorService.fetchAllRoles().subscribe(response => {
      this.roles = response
      this.hideLoading();
    },error => this.handleError(error));
  }

  handleError(error: any): void {
    this.hideLoading();
    this.errorMessage = 'Error Loading Roles';
    console.log(error);
    
    setTimeout(()=>this.errorMessage = undefined, 4000)
  }

  initForm() {
    this.userRegisterationForm = new FormGroup(
      {
        username: new FormControl(
          '',
          [
            Validators.required,
            Validators.minLength(4),
            Validators.pattern('^[a-zA-Z][a-zA-Z0-9-_\\.]{4,12}$'),
          ],
          CustomValidators.usernameValidator(this.validatorService)
        ),
        password: new FormControl('', [
          Validators.required,
          Validators.pattern(
            '^(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{6,12}$'
          )
        ]),
        confirmPassword: new FormControl('', [
          Validators.required,
          Validators.pattern(
            '^(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}$'
          ),
        ]),
        role: new FormGroup({
          roleId: new FormControl('', Validators.required),
        }),
      },
      { validators: CustomValidators.matchPassword }
    );
  }

  /**
   * Executed when a form is submitted
   */
  onSubmit() {
    this.submitted = true;
    if (this.userRegisterationForm.valid) {
      this.isLoading = true;
      this.submitted = false;
      delete this.userRegisterationForm.value.confirmPassword;
      const newUser: UserForm = this.userRegisterationForm.value;
      console.log(newUser);
      this.employeeService.userEmitter.next(newUser);
      this.router.navigate(['/employee/admin/addemp']);
    }
  }
  
  showLoading() {
    this.isLoading = true;
  }

  hideLoading() {
    this.isLoading = false;
  }
}
