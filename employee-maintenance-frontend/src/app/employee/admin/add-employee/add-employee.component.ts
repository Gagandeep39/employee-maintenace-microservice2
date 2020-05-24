/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-13 08:31:42
 * @modify date 2020-05-13 08:31:42
 * @desc Add Employee details form
 */
import { Component, OnInit } from '@angular/core';
import { MaritalStatus } from 'src/app/models/marital-status.model';
import { Gender } from 'src/app/models/gender.model';
import { Department } from 'src/app/models/department.model';
import { Manager } from 'src/app/models/manager.model';
import { Grade } from 'src/app/models/grade.model';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { User } from 'src/app/models/user.mode';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';
import { ValidatorService } from 'src/app/service/validator.service';
import { CustomValidators } from 'src/app/shared/custom-validators';
import { UserDetailsFrom } from 'src/app/models/details-form.model';
import { Designation } from 'src/app/models/designation.model';
import { UserForm } from 'src/app/models/user-form.model';
import { EmployeeDetails } from 'src/app/models/employee-details.model';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css'],
})
export class AddEmployeeComponent implements OnInit {
  submitted = false;
  editMode = false;
  maritalStatus = MaritalStatus;
  genders = Gender;
  departments: Department[] = [];
  managers: Manager[] = [];
  grades: Grade[] = [];
  designations = Designation;

  employeeForm: FormGroup;
  selectedGrade: Grade;

  isLoading = false;
  currentUser: User;
  error = '';
  userForm: UserForm;

  referenceMessage: string;

  // Edit Employee 
  empId: number;
  employeeDetails: EmployeeDetails;

  // Error and loading
  errorMessage: string;

  constructor(
    private employeeService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute,
    private validatorService: ValidatorService
  ) {}

  ngOnInit() {
    this.initDropdowns();
    this.initEmployeeForm();
    if(this.route.snapshot.url[1].path==="addemp") this.fetchUserFormData();
    else if (this.route.snapshot.params['id']) this.updateEmployee();
  }
  updateEmployee() {
    this.empId = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.empId).subscribe(response => {
      this.employeeDetails = response;
      this.populateFormFields();
    })
    
  }
  populateFormFields() {
    this.employeeForm.patchValue({
      empDetailsId: this.employeeDetails.empDetailsId,
      firstName: this.employeeDetails.firstName,
      lastName: this.employeeDetails.lastName,
      dateOfBirth: this.employeeDetails.dateOfBirth,
      dateOfJoining: this.employeeDetails.dateOfJoining,
      maritalStatus: this.employeeDetails.maritalStatus,
      gender: this.employeeDetails.gender,
      department: {
        departmentId: this.employeeDetails.department.departmentId
      },
      manager: {
        empDetailsId: this.employeeDetails.manager
      },
      grade: this.employeeDetails.grade,
      designation: this.employeeDetails.designation,
      basic: this.employeeDetails.basic,
      phoneNumber: this.employeeDetails.phoneNumber,
      email: this.employeeDetails.email,
      address: {
        state: this.employeeDetails.address.state,
        area: this.employeeDetails.address.area,
        city: this.employeeDetails.address.city,
        pincode: this.employeeDetails.address.pincode
      }
    })
  }
  initDropdowns() {
    this.selectedGrade = new Grade();
    this.validatorService.fetchAllDepartments().subscribe((response) => (this.departments = response));
    this.validatorService.fetchAllGrades().subscribe((response) => (this.grades = response));
    this.validatorService.fetchAllManagers().subscribe((response) => this.managers = response);
  }

  fetchUserFormData() {
    this.userForm = this.employeeService.userEmitter.value;
    if(this.userForm == null) 
      this.router.navigate(['/employee/home']);
  }

  initEmployeeForm() {
    this.employeeForm = new FormGroup({
      empDetailsId: new FormControl(''),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      dateOfBirth: new FormControl('', [
        Validators.required,
        CustomValidators.forbiddenAge,
        CustomValidators.forbidFutureDate
      ]),
      dateOfJoining: new FormControl('', [
        Validators.required,
        // CustomValidators.forbidFutureDate,
      ]),
      maritalStatus: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
      department: new FormGroup({
        departmentId: new FormControl('', Validators.required),
      }),
      manager: new FormGroup({
        empDetailsId: new FormControl('', Validators.required),
      }),
      grade: new FormControl('', Validators.required),
      designation: new FormControl('', Validators.required),
      basic: new FormControl('', [
        Validators.required,
        (control: FormControl) =>
          CustomValidators.forbiddenSalary(this.selectedGrade)(control),
      ]),
      phoneNumber: new FormControl('', [
        Validators.required,
        Validators.pattern('[7-9][0-9]{9}'),
      ]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormGroup({
        state: new FormControl('', Validators.required),
        area: new FormControl('', Validators.required),
        city: new FormControl('', Validators.required),
        pincode: new FormControl('', [
          Validators.required,
          Validators.pattern('[0-9]{6}'),
        ]),
      }),
    });
  }

  submitForm() {
    this.submitted = true;
    if (this.employeeForm.valid) {
      if(this.employeeDetails !=undefined){
        this.updateDataOnServer(this.employeeForm.value);
      }
      else 
        this.saveDataToServer(this.employeeForm.value);
    }
  }
  updateDataOnServer(userDetails: UserDetailsFrom) {
    this.showLoading();
    this.employeeService.updateEmployee(userDetails)
      .subscribe(
        response =>{
          this.hideLoading();
          this.employeeService.userEmitter.next(null);
          this.referenceMessage = "Successfully Updated Employee with ID: " + response.empDetailsId;
          setTimeout(()=> {
            this.router.navigate(['/employee/home'])
          }, 2000)
        },
        error => this.handleError(error)
      )
  }

  gradeIsSelected(event) {
    this.selectedGrade = this.grades.find(
      (g) => g.gradeCode === event.target.value
    );
  }

  saveDataToServer(userDetails: UserDetailsFrom) {
    this.showLoading();
    this.userForm.employeeDetails = userDetails;
    this.employeeService.saveEmployee(this.userForm)
    .subscribe(response =>{
      this.hideLoading();
      this.employeeService.userEmitter.next(null);
      this.referenceMessage = "Successfully Added Employee with ID: " + response.empDetailsId;
      setTimeout(()=> {
        this.router.navigate(['/employee/home'])
      }, 2000)
    },
    error => this.handleError(error));
  }

  OnInit() {}

  handleError(error: any): void {
    this.hideLoading();
    this.errorMessage = 'Error Communicting to server';
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
