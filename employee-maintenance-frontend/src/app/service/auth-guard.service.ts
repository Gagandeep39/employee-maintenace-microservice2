/**
 * @author Pranav Karmarkar
 */
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(public auth: AuthService, public router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.auth.isUserLoggedIn()) {
      if (route.url.toString() == "search" || route.url.toString() == "leaves" || route.url.toString() == "home" ||
        route.url.toString().startsWith("details,") || route.url.toString() == "addleave" || route.url.toString() == "change")
        return true;
      else if (route.url.toString() == "admin,adduser" || route.url.toString() == "admin,addemp" ||
        route.url.toString().startsWith("admin,edituser,") || route.url.toString().startsWith("admin,editemp,") ||
        route.url.toString() == "admin,viewuser") {
        if (this.auth.typeOfUser() == "ROLE_ADMIN")
          return true;
        else {
          this.router.navigate(['/error/403']);
          return false;
        }
      }
      else if (route.url.toString() == "manager,approve") {
        if (this.auth.typeOfUser() == "ROLE_MANAGER")
          return true;
        else {
          this.router.navigate(['/error/403']);
          return false;
        }
      }
    }
    else {

      this.router.navigate(['/login']);
      return false;
    }
  }
}
