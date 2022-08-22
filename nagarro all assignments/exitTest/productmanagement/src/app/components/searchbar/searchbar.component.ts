import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductserviceService } from 'src/app/services/productservice/productservice.service';
import { RatingModule } from 'ng-starrating';
import { LoginComponent } from 'src/app/modules/user/components/login/login.component';
@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss']
})
export class SearchbarComponent implements OnInit {
static code:any;
userType=false;
check:any;
  constructor(private productService:ProductserviceService,
    private routes:Router) { }
    productArray:any;
    val:any;
    num:number=3;
  ngOnInit(): void {
    this.userSubmit();
    console.log(LoginComponent.type,"type");
    if(localStorage.getItem("type")=="admin")
    {
      console.log(localStorage.getItem("type"));
      this.userType=true;
    }
  }

  userForm = new FormGroup({
    'brand':new FormControl('',Validators.required),
    'name':new FormControl('',Validators.required),
    'productCode':new FormControl('',Validators.required),
    'image':new FormControl('',Validators.required)

  });
  // data=[
  userSubmit()
  {
    console.log("hiii");
    console.log(this.userForm.value);
   this.productService.getproduct(this.userForm.value).subscribe((res)=>{
    this.productArray=res;
    this.productService.storeData(res);
    console.log(this.productArray[0][0],"stored value");
    console.log(this.productArray,"new product");
   })

 
  }

  review(data:any)
  {
      SearchbarComponent.code=data;
    console.log("hellow review ",data);
    this.routes.navigate(['user/review']);
    
  }

  adminreview(data:any)
  {
    SearchbarComponent.code=data;
    this.routes.navigate(['admin/review']);
  }

  approve()
  {
    console.log("approve");
    this.routes.navigate(['admin/approve']);
  }
  comment(data:any)
  {
    SearchbarComponent.code=data;
    this.routes.navigate(['user/comment']);

  }

  askReview()
  
  {
    this.routes.navigate(['user/askreview']);
  }

}

