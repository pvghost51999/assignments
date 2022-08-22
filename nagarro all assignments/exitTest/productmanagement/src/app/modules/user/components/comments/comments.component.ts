import { Component, OnInit } from '@angular/core';
import { ReviewserviceService } from 'src/app/services/reviewservice/reviewservice.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
  productArray:any;
  constructor(private reviewService:ReviewserviceService) { }

  ngOnInit(): void {
this.all();

  }


  all()
  {    this.reviewService.getAllStatusTrue().subscribe((res)=>{
  //  
  // localStorage.setItem("comment",JSON.stringify(res));
    this.reviewService.setProductArray(res);
    this.productArray=res;
    // this.productArray=JSON.parse(JSON.stringify(localStorage.getItem("shareData")));
    console.log(this.productArray,"after save");
    // this.productArray=res;
  })}

}
