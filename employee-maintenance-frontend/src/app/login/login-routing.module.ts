/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:35:44
 * @modify date 2020-05-09 17:35:44
 * @desc To declar all routes for login Module
 */

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { UserLoginComponent } from "./user-login/user-login.component";

const routes: Routes = [
    { path: 'login', component: UserLoginComponent }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class LoginRoutingModule {}
