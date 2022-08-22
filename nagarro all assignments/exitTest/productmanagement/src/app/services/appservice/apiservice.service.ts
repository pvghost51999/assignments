import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  constructor(private _http:HttpClient) { }
  
regurl="http://localhost:8082/register"
loginurl="http://localhost:8082/login"

  registerData(data:any):Observable<any>
{

  return this._http.post(`${this.regurl}`,data,{responseType: 'text'});
}

loginData(data:any):Observable<any>
{
  return this._http.post(`${this.loginurl}`,data)
}
}
