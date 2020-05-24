/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-13 03:10:07
 * @modify date 2020-04-13 03:10:07
 * @desc TO provide basic employee Search
 */

import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/service/employee.service';
import { EmployeePage } from 'src/app/models/employee-page.model';
import { ValidatorService } from 'src/app/service/validator.service';
import { Department } from 'src/app/models/department.model';
import { Grade } from 'src/app/models/grade.model';
import { MaritalStatus } from 'src/app/models/marital-status.model';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css'],
})
export class SearchEmployeeComponent implements OnInit {
  public employeePage: EmployeePage = new EmployeePage();
  public currentPage: number;
  departments : Department[]= [];
  grades : Grade[]=[];
  maritalStatuses : MaritalStatus[]=[];
  category: string = 'all';
  value: string;
  nameType : string;
  isLoading = false;
  errorMessage: string;

  constructor(private employeeService: EmployeeService, private validatorService: ValidatorService) {}

  ngOnInit() {
    this.fetchDatafromServer(0);
    this.currentPage = 0;
    this.validatorService.fetchAllDepartments().subscribe(response => this.departments = response);
    this.validatorService.fetchAllGrades().subscribe(response => this.grades = response);
    this.maritalStatuses=Object.values(MaritalStatus);
  }

  fetchDatafromServer(pageNo: number, pageSize = 10) {
    this.showLoading();
    this.employeeService
      .getEmployeeByCategory(pageNo, pageSize, this.category, this.value)
      .subscribe((response) => {
        this.employeePage = response;
        this.hideLoading();
      },error => this.handleError(error));
  }

  handleError(error: any): void {
    this.hideLoading();
    this.errorMessage = 'Something Went Wrong :(';
    console.log(error);
    setTimeout(()=>this.errorMessage = undefined, 4000)
  }

  goToPage(pageNo: number) {
    this.currentPage = pageNo;
    this.fetchDatafromServer(pageNo);
  }

  previousPage() {
    this.fetchDatafromServer(--this.currentPage);
  }

  nextPage() {
    this.fetchDatafromServer(++this.currentPage);
  }

  counter(i: number) {
    return new Array(i);
  }

  searchItem(category: string, value: string) {
    this.category = category;
    this.value = value;
    this.fetchDatafromServer(0);
    this.nameType = undefined;
  }

  searchByName(category: string, value: string) {
    this.category = category;
    this.value = value;
    this.fetchDatafromServer(0);
    this.nameType = undefined;
  }

  setSearchType(type: string){
    this.nameType = type;
  }

  showLoading() {
    this.isLoading = true;
  }

  hideLoading() {
    this.isLoading = false;
  }

}
