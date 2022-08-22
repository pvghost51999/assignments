import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from 'src/app/services/loginservice/loginservice.service';
import { ProductserviceService } from 'src/app/services/productservice/productservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private loginservice:LoginserviceService,
    private routes:Router,
    private productservice:ProductserviceService) { }

  ngOnInit(): void {



  }

  

  

}
