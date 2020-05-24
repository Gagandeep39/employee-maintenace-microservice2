import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { SharedRoutingModule } from './shared-routing.module';
import { GradeTypePipe } from './grade-type.pipe';
import { ManagerInfoPipe } from './manager-info.pipe';
import { AboutUsComponent } from './about-us/about-us.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedRoutingModule
    ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    AccessDeniedComponent,
    GradeTypePipe,
    ManagerInfoPipe,
    AboutUsComponent,
  ],
  exports: [ 
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    AccessDeniedComponent,
    GradeTypePipe,
    ManagerInfoPipe
  ]
})
export class SharedModule { }
