import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiserviceService } from 'src/app/services/appservice/apiservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  constructor(private service :ApiserviceService,
    private routes :Router) { }
  error:any
  ngOnInit(): void {
  }
  regForm = new FormGroup({
    'email':new FormControl('',Validators.required),
    'firstName':new FormControl('',Validators.required),
    'lastName':new FormControl('',Validators.required),
    'password':new FormControl('',Validators.required),

  });

  registration()
  {
    this.service.registerData(this.regForm.value).subscribe((res)=>{
      if(res=="false")
      {
        this.error=true
      }
      else
      {
        this.routes.navigate(['/login'])
        this.error=false
      }
      
    })
  }

}
