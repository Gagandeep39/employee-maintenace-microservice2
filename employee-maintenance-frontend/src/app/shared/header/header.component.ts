/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 19:08:31
 * @modify date 2020-05-09 19:08:31
 * @desc Header Component Logic
 */
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { User } from 'src/app/models/user.mode';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: User;
  role: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.user = this.authService.fetchFromSessionStorage();
    this.role = this.user.role.role;
  }

  logOut() : void {
    this.authService.logOut();
  }

}
