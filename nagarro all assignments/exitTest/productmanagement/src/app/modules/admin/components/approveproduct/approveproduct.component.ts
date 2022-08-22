import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { throws } from 'assert';
import { ProductserviceService } from 'src/app/services/productservice/productservice.service';

@Component({
  selector: 'app-approveproduct',
  templateUrl: './approveproduct.component.html',
  styleUrls: ['./approveproduct.component.scss']
})
export class ApproveproductComponent implements OnInit {
productArray:any;
  constructor(private productService:ProductserviceService
    ,private routes:Router) { }

  ngOnInit(): void {
    this.productService.statusProduct().subscribe((res)=>{
      this.productArray=res;
      console.log(res);
    })

  }

  approveStatus(data:any)
  {
    data.status=true;
    this.productService.approve(data).subscribe((res)=>{
        console.log("success");
        this.routes.navigate(['admin/products']);
    })
  }

  rejectStatus(data:any)
  {
      console.log(data,"i rejected");
      this.productService.deleteProduct(data).subscribe((res)=>{
        console.log("sucessfully deleted")
        this.routes.navigate(['admin/approve']). then(() => {
          window. location. reload();
          });;
      })
    // this.routes.navigate(['admin/products']);
  }
}
