import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SearchbarComponent } from 'src/app/components/searchbar/searchbar.component';
import { ReviewComponent } from 'src/app/modules/user/components/review/review.component';

@Injectable({
  providedIn: 'root'
})
export class ReviewserviceService {
  productData:any;
  url="http://localhost:8082"
  constructor(private http:HttpClient) { }
  code:any
  productArray:any;
  setReview(data:any):Observable<any>
  {
    return this.http.post(`${this.url}/products/${ReviewComponent.code}`,data);
  }

  setProductArray(data:any)
  {
this.productArray=data;
  }

  getProductArray()
  {
    return this.productArray;
  }
  getAllReviews()
  {
    return this.http.get(`${this.url}/products/${SearchbarComponent.code}`)
  }


  approveReview(data:any)
{
   return this.http.put(`${this.url}/products/${this.code}`,data)
}


getAllStatusTrue()
{
  return this.http.get(`${this.url}/products/status/${SearchbarComponent.code}`)
}

setSno(data:any)
{
  this.code=data;
}
getSno()
{return this.code}
}




