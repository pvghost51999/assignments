import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from 'src/app/services/loginservice/loginservice.service';
import { ProductserviceService } from 'src/app/services/productservice/productservice.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  loggedIn=false;
  username:any
  val:any

  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  imageName: any;
  productArray:any

  constructor(private loginservice:LoginserviceService,
    private routes:Router,
    private productservice:ProductserviceService) {}
  ngOnInit(): void {


    console.log(this.loggedIn);
    if(this.loginservice.isLoggedIn())
    {
      this.loggedIn=true;
    }
    this.username=localStorage.getItem("name");
    this.productArray=this.productservice.getStoreData();
    console.log(this.productArray,"productArray");
  }


  loginRoute()
  {
    console.log("hello inside");
    this.routes.navigate(['/login']);

  }

  

  logout()
  {
    console.log("logout");
    localStorage.removeItem("token");
    localStorage.removeItem("type");
    // localStorage.removeItem("email");
    this.routes.navigate(['']).then(()=>{
      window.location.reload();
    });
  

  }

}
