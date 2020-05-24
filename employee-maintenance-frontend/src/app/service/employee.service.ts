import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { EmployeePage } from '../models/employee-page.model';
import { EmployeeDetails } from '../models/employee-details.model';
import { BehaviorSubject } from 'rxjs';
import { UserForm } from '../models/user-form.model';
import { UserDetailsFrom } from "../models/details-form.model";
import { User } from '../models/user.mode';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  findUserById(empId: number) {
    return this.httpClient.get<User>(environment.url + environment.findUserById + empId);
  }

  updateUser(user: User) {
    return this.httpClient.put<User>(environment.url + environment.updateUser, user);
  }

  updateEmployee(userDetailsForm: UserDetailsFrom) {
    return this.httpClient.put<EmployeeDetails>(environment.url + environment.addEmployee, userDetailsForm);
  }
  
  saveEmployee(userForm: UserForm) {
    return this.httpClient.post<EmployeeDetails>(environment.url + environment.addEmployee, userForm);
  }

  changePassword(user: User) {
    return this.httpClient.put<User>(environment.url + environment.changePassword, user);
  }
  public userEmitter: BehaviorSubject<UserForm> = new BehaviorSubject<UserForm>(null);

  searchByName(searchString: string) {
    let params = new HttpParams();
    params = params.set('name', searchString);
    return this.httpClient.get<EmployeePage>(environment.url + environment.byName,
      {
        params: params
      });
  }

  constructor(private httpClient: HttpClient) { }

  getEmployeePages(pageNo: number, pageSize = 10, sortBy = undefined) {
    let params = new HttpParams();
    params = params.set('pageNo', pageNo.toString());
    params = params.set('pageSize', pageSize.toString());
    if (sortBy !== undefined && sortBy !== null) {
      params = params.set('sortBy', sortBy.toString());
    }
    return this.httpClient.get<EmployeePage>(environment.url + environment.fetchAllEmployee,
      {
        params: params
      });
  }

  getEmployeeById(id: number) {
    return this.httpClient.get<EmployeeDetails>(environment.url + environment.byId + id);
  }

  getEmployeeByCategory(pageNo: number, pageSize = 10, category: string, value: string) {
    let params = new HttpParams();
    console.log("----------");
    
    params = params.set('pageNo', pageNo.toString());
    params = params.set('pageSize', pageSize.toString());
    params = params.set(category, value);
    console.log(params);
    
    return this.httpClient.get<EmployeePage>(environment.url + environment.searchByCategory,
      {
        params: params
      });
  }

}
