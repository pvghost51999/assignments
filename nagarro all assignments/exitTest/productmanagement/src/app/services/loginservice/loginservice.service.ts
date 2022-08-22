import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  url="http://localhost:8082"
  constructor(private http :HttpClient) {  }

  name:any;
  generateToken(data:any)
  {
    return this.http.post(`${this.url}/login`,data);
  }
  
  userName(name:any)
  {
    this.name=name;
  }
  
  getUserName()
  {
    return this.name;
  }
  
  loginUser(token:any)
  {
    localStorage.setItem("token",token);
    return true;
  }

  isLoggedIn()
  {
    let token=localStorage.getItem("token");

    if(token==undefined || token==null || token=='')
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  logout()
  {
    localStorage.removeItem("token");
    return true;
  }

  getToken()
  {
    return localStorage.getItem("token");
  }
}
