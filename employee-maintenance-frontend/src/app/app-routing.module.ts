/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:35:44
 * @modify date 2020-05-09 17:35:44
 * @desc To declar all routes for the application
 */

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from './employee/employees/home/home.component';

const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
