import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './employees/home/home.component';
import { CreateLeaveComponent } from './employees/create-leave/create-leave.component';
import { ChangePasswordComponent } from './employees/change-password/change-password.component';
import { AddEmployeeComponent } from './admin/add-employee/add-employee.component';
import { EditEmployeeComponent } from './admin/edit-employee/edit-employee.component';
import { ApproveLeaveComponent } from './manager/approve-leave/approve-leave.component';
import { SearchEmployeeComponent } from './employees/search-employee/search-employee.component';
import { ViewLeavesComponent } from './employees/view-leaves/view-leaves.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './employee.component';
import { AddUserComponent } from '../employee/admin/add-user/add-user.component';
import { ViewUserComponent } from './admin/view-user/view-user.component';
import { EditUserComponent } from './admin/edit-user/edit-user.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    EmployeeRoutingModule,
    SharedModule
  ],
  declarations: [
    HomeComponent,
    CreateLeaveComponent,
    ChangePasswordComponent,
    AddEmployeeComponent,
    EditEmployeeComponent,
    ApproveLeaveComponent,
    SearchEmployeeComponent,
    ViewLeavesComponent,
    EmployeeComponent,
    AddUserComponent,
    ViewUserComponent,
    EditUserComponent
  ]
})
export class EmployeeModule { }
