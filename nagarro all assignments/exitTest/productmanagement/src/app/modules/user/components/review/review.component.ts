import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SearchbarComponent } from 'src/app/components/searchbar/searchbar.component';
import { ReviewserviceService } from 'src/app/services/reviewservice/reviewservice.service';
import { LoginComponent } from '../login/login.component';
@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class ReviewComponent implements OnInit {
  success:any;
  data:any;
  static code:any
  check:boolean=false;
  constructor(private reviewService:ReviewserviceService,
    private routes:Router) { }
gender:any;
  ngOnInit(): void {
  }
  userForm = new FormGroup({
    'rating':new FormControl('',Validators.required),
    'comment':new FormControl('',Validators.required),
    'productCode':new FormControl(SearchbarComponent.code),
    'email':new FormControl(localStorage.getItem("email")),
    'status':new FormControl(this.check)
  });
  review()
  {
    ReviewComponent.code=this.userForm.value.productCode;
    this.gender=this.userForm.value;
    console.log(this.gender,"hiii i am comment");
    this.reviewService.setReview(this.userForm.value).subscribe((res)=>{
      this.success=true;
      setTimeout(() => {
        this.routes.navigate(['/user/products']);
    }, 1000);
      console.log("success comment");
    },
    err=>{

      console.log(err.message);
    }
    
    )
  }
}
