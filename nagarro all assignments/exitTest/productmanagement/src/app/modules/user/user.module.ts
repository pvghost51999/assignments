import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { ProductsComponent } from './components/products/products.component';
import { HomeComponent } from 'src/app/components/home/home.component';
// import { HomeComponent } from 'src/app/modules/home/home.component';
import { HomemoduleModule } from 'src/app/components/homemodule/homemodule.module';
import { ReviewComponent } from './components/review/review.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RatingModule } from 'ng-starrating';
import { BrowserModule } from '@angular/platform-browser';
import { CommentsComponent } from './components/comments/comments.component';
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddproductComponent } from './components/addproduct/addproduct.component';

import { ConfirmationdailogComponent } from './components/confirmationdailog/confirmationdailog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
@NgModule({
  declarations: [
   ProductsComponent,
   ReviewComponent,
   CommentsComponent,
   AddproductComponent,
   ConfirmationdailogComponent,
  //  HomeComponent
  
  ],

  imports: [
    CommonModule,
    UserRoutingModule,
    // HomeComponent 
    HomemoduleModule,
    FormsModule,
    ReactiveFormsModule,
    RatingModule ,NgbModule,
    MatDialogModule,
    // BrowserAnimationsModule
  ],

})
export class UserModule { }
   