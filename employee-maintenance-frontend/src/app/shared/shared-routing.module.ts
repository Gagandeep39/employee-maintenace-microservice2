/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:35:44
 * @modify date 2020-05-09 17:35:44
 * @desc To declar routes for Shared Components
 */

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { AboutUsComponent } from './about-us/about-us.component';

const routes: Routes = [
    { path: 'header', component: HeaderComponent },
    { path: 'footer', component: FooterComponent },
    { path: 'error/404', component: PageNotFoundComponent },
    { path: 'error/403', component: AccessDeniedComponent },
    { path: 'aboutus', component: AboutUsComponent},
    { path: '**', redirectTo: 'error/404' }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class SharedRoutingModule {}
