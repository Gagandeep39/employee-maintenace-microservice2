/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 08:55:31
 * @modify date 2020-05-11 08:55:31
 * @desc To fetch data for admin form validattion
 */

import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Department } from '../models/department.model';
import { environment } from 'src/environments/environment';
import { Manager } from '../models/manager.model';
import { Grade } from '../models/grade.model';
import { map } from 'rxjs/operators';
import { UsernameExists } from '../models/username-exists.model';
import { Role } from '../models/role.model';

@Injectable({
  providedIn: 'root'
})
export class ValidatorService {
  validateUser(username: string) {
    let params = new HttpParams();
    params = params.set('username', username);
    return this.httpClient.get<UsernameExists>(environment.url + environment.validateUsername, {
      params: params
    })
    .pipe(
      map(response => {
        // Retun false if user exists
        return !response.exists;
      })
    );
  }

  constructor(private httpClient: HttpClient) { }

  fetchAllDepartments(){
    return this.httpClient.get<Department[]>(environment.url + environment.departments);
  }

  fetchAllManagers() {
    return this.httpClient.get<Manager[]>(environment.url + environment.managers);
  }

  fetchAllGrades() {
    return this.httpClient.get<Grade[]>(environment.url + environment.grades);
  }

  fetchAllRoles() {
    return this.httpClient.get<Role[]>(environment.url + environment.roles);
  }

}
