import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { ApiserviceService } from 'src/app/services/appservice/apiservice.service';
import { Router } from '@angular/router';
import { LoginserviceService } from 'src/app/services/loginservice/loginservice.service';
import { toJSDate } from '@ng-bootstrap/ng-bootstrap/datepicker/ngb-calendar';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class LoginComponent implements OnInit {
  static user:any;
  val:any;
  loggedIn=false;
  static type:any
  constructor(private service:LoginserviceService,
    private routes:Router) { }
    error:any;
    message:any;
  ngOnInit(): void {

  }

  userForm = new FormGroup({
    'email':new FormControl('',Validators.required),
    'password':new FormControl('',Validators.required),

  });

  userSubmit()
  {
    // console.log(this.userForm.value);

    this.service.generateToken(this.userForm.value).subscribe((res:any)=>{
      
      // val=this.data.res;
      this.service.loginUser(res.token);
      console.log(res);
      this.service.userName(res.name);
      if(this.userForm.value.email=="" || this.userForm.value.password=="")
      {
        this.routes.navigate(['/login']);
        this.error=true;
        this.message="*enter all fields!!"
        
      }
      // else if(res)
      // {
      //   this.routes.navigate(['/user/home']);
      //   this.error=false;
      // }
      else
      {
        localStorage.setItem("email",this.userForm.value.email);
        console.log(LoginComponent.user);
 
        localStorage.setItem("name",res.name);
        if(res.type=="user")
        {
        this.routes.navigate(['/user/products'])        
        .then(() => {
          window.location.reload();
        });;
        }
        else
        {
          localStorage.setItem("type",res.type);
          this.routes.navigate(['/admin/products'])        
          
          .then(() => {
            window.location.reload();
          });;
        }

       
        this.error=false;
       
      }
      
    },
    err=>{
      console.log(err.message);
      this.error=true;
      if(this.userForm.value.email=="" || this.userForm.value.password=="")
      {
        this.routes.navigate(['/login']);
        this.error=true;
        this.message="*enter all fields!!"
      }
      else
      this.message="*invalid user"
    }
    )

  }
}
