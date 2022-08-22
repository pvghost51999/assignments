import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { HomeComponent } from 'src/app/components/home/home.component';
import { LoginserviceService } from 'src/app/services/loginservice/loginservice.service';
import { ProductserviceService } from 'src/app/services/productservice/productservice.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  username: any;

  constructor(private service:LoginserviceService,private change: ChangeDetectorRef,private productService:ProductserviceService) { }

  ngOnInit(): void {
    // window.location.reload();
    // this.change.detectChanges();
    this.username=this.service.getUserName();

  }


}
