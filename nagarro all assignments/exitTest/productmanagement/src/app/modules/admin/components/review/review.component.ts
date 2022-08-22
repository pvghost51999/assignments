import { Component, OnInit } from '@angular/core';
import { ReviewserviceService } from 'src/app/services/reviewservice/reviewservice.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.scss']
})
export class ReviewComponent implements OnInit {
  static sno:any
  productArray:any
  constructor(private reviewService:ReviewserviceService) { }

  ngOnInit(): void {
this.all();

  }

  all()
  {
    this.reviewService.getAllReviews().subscribe((res)=>{
      console.log(res,Comment);
      console.log(res);
      this.productArray=res;
    })
  }
approve(data:any)
{
  // console.log(data,"val");
data.status=true
console.log(data);
this.reviewService.setSno(data.sno);
this.reviewService.approveReview(data).subscribe((res)=>{
  console.log("success",res)
},
err=>{
  console.log(err.message);
}

)
}



}
