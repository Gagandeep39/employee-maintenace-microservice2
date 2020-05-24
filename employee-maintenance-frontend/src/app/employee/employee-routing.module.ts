/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:35:44
 * @modify date 2020-05-09 17:35:44
 * @desc To declar all Employee Routes
 */

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { SearchEmployeeComponent } from './employees/search-employee/search-employee.component';
import { ViewLeavesComponent } from './employees/view-leaves/view-leaves.component';
import { HomeComponent } from './employees/home/home.component';
import { CreateLeaveComponent } from './employees/create-leave/create-leave.component';
import { ChangePasswordComponent } from './employees/change-password/change-password.component';
import { AddEmployeeComponent } from './admin/add-employee/add-employee.component';
import { EditEmployeeComponent } from './admin/edit-employee/edit-employee.component';
import { ApproveLeaveComponent } from './manager/approve-leave/approve-leave.component';
import { EmployeeComponent } from './employee.component';
import { AddUserComponent } from './admin/add-user/add-user.component';
import { AuthGuardService } from '../service/auth-guard.service';
import { EditUserComponent } from './admin/edit-user/edit-user.component';
import { ViewUserComponent } from './admin/view-user/view-user.component';



const routes: Routes = [
    {
        path: 'employee', component: EmployeeComponent, children: [
            { path: '', redirectTo: 'home', pathMatch: 'full' },
            { path: 'search', component: SearchEmployeeComponent, canActivate : [AuthGuardService]},
            { path: 'leaves', component: ViewLeavesComponent, canActivate : [AuthGuardService] },
            { path: 'home', component: HomeComponent, canActivate : [AuthGuardService] },
            { path: 'details/:id', component: HomeComponent, canActivate : [AuthGuardService] },
            { path: 'addleave', component: CreateLeaveComponent, canActivate : [AuthGuardService] },
            { path: 'change', component: ChangePasswordComponent, canActivate : [AuthGuardService] },
            { path: 'admin/adduser', component: AddUserComponent, canActivate : [AuthGuardService] },
            { path: 'admin/edituser/:id', component: EditUserComponent, canActivate : [AuthGuardService]},
            { path: 'admin/addemp', component: AddEmployeeComponent, canActivate : [AuthGuardService] },
            { path: 'admin/editemp/:id', component: AddEmployeeComponent , canActivate : [AuthGuardService]},
            { path: 'admin/viewuser', component: ViewUserComponent , canActivate : [AuthGuardService]},
            { path: 'manager/approve', component: ApproveLeaveComponent, canActivate : [AuthGuardService] },
        ]
    },
    // { path: '**', redirectTo: 'error/404' }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class EmployeeRoutingModule {}
