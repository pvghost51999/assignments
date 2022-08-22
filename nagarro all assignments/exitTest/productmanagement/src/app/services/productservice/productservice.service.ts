import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {
  productData: any;
  url = "http://localhost:8082"
  constructor(private http: HttpClient) { }

  getproduct(data: any) {
    return this.http.post(`${this.url}/products`, data);
  }

  statusProduct() {
    return this.http.get(`${this.url}/products`);
  }
  approve(data: any) {
    return this.http.post(`${this.url}/products/approved`, data);
  }


  deleteProduct(data:any)
  {
     return  this.http.delete(`${this.url}/products/${data.productCode}`)
  }

  addProduct(data: any) {
    return this.http.post(`${this.url}/add`, data);
  }
  // getproduct()
  // {
  //   return this.http.get(`${this.url}/products`);
  // }

  storeData(data: any) {
    this.productData = data;
    // return this.productData;
  }
  getStoreData() {
    return this.productData;
  }

}
