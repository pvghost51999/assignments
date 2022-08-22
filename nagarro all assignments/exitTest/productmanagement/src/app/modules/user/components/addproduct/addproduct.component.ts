import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SearchbarComponent } from 'src/app/components/searchbar/searchbar.component';
import { ProductserviceService } from 'src/app/services/productservice/productservice.service';
import { ConfirmationdailogComponent } from '../confirmationdailog/confirmationdailog.component';
@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.scss']
})
export class AddproductComponent implements OnInit {
  message: any;
  check = false;
  constructor(private productService: ProductserviceService,
    private routes: Router,public dialog:MatDialog) { }

  productArray: any;
  ngOnInit(): void {
  }



  userForm = new FormGroup({
    'brand': new FormControl('', Validators.required),
    'name': new FormControl('', Validators.required),
    'productCode': new FormControl('', Validators.required),
    'image': new FormControl('', Validators.required),
    'status': new FormControl(false),

  });
  // data=[

  openDialog()
  {
    console.log("dialog");
this.dialog.open(ConfirmationdailogComponent)
  }


  userSubmit() {
    if (this.userForm.value.brand != "" && this.userForm.value.name != "" && this.userForm.value.productCode != "" && this.userForm.value.image != "") 
    {
      console.log("productCode");
      console.log(this.userForm.value);
      var array = this.userForm.value.image;
      var temp = "";
      for (let i = array.length - 1; i >= 0; i--) {
        if (array[i] == "\\") {
          break

          console.log(i, array[i]);
        }
        if (array[i] != ".") {
          temp = array[i] + temp;
        }
        console.log(i, array[i]);
      }
      console.log("hii log ", temp);
      this.userForm.value.image = temp;
      this.productService.getproduct(this.userForm.value).subscribe((res) => {

        this.productArray = res;
        console.log(this.productArray.length == 1);
        // if product already exits
        if (this.productArray.length == 1) {

          console.log()
          SearchbarComponent.code = this.userForm.value.productCode;
          this.message = "Product already exits"
          this.check = true;
          setTimeout(() => {
            this.routes.navigate(['user/comment']);
          }, 1000);

        }

        else {
          //if product don't exits
          this.productService.addProduct(this.userForm.value).subscribe((res) => {

            console.log("everthing is going smooth");
            this.routes.navigate(['user/products'])
          })
        }


      })
    }

    else {
      this.check=true;
      this.message="All fields are Required"
      console.log("error occured");
    }
  }


}
