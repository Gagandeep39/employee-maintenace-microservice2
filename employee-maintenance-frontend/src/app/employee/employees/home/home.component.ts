/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-10 15:24:06
 * @modify date 2020-05-10 15:24:06
 * @desc Shows User Info
 */
import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from 'src/app/models/employee-details.model';
import { EmployeeService } from 'src/app/service/employee.service';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { User } from 'src/app/models/user.mode';
import { Location } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  userInfo: User;
  employee: EmployeeDetails;
  isLoading = false;

  constructor(
    private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private location: Location
  ) {}

  ngOnInit() {
    if (this.activatedRoute.snapshot.url[0].path.includes('home')) {
      this.userInfo = this.authService.fetchFromSessionStorage();
      this.employee = this.userInfo.employeeDetails;
    } else {
      let empId = this.activatedRoute.snapshot.params['id'];
      this.fetchUserInfo(empId);
    }
  }

  fetchUserInfo(empId: number) {
    this.showLoading();
    this.employeeService.getEmployeeById(empId).subscribe((response) => {
      this.employee = response;
      this.hideLoading();
    });
  }

  goBack() {
    this.location.back();
  }

  showLoading(){
    this.isLoading = true;
  }

  hideLoading() {
    this.isLoading = false;
  }

}
