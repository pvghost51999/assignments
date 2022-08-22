import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginserviceService } from './services/loginservice/loginservice.service';



@Injectable({
  providedIn: 'root'
})


export class AuthguardGuard implements CanActivate {
  constructor(private loginservice:LoginserviceService,private routes:Router)
{
  
}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.loginservice.isLoggedIn())
    {  
    return true;
    }
    else
    {
      this.routes.navigate(['/login']);
      return false;
    }
  }
  
}
