import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';

import { ProductsComponent } from './components/products/products.component';
import { ReviewComponent } from './components/review/review.component';

import { HomemoduleModule } from 'src/app/components/homemodule/homemodule.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ApproveproductComponent } from './components/approveproduct/approveproduct.component';
@NgModule({
  declarations: [
    ProductsComponent,
    ReviewComponent,
    ApproveproductComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    HomemoduleModule,
    NgbModule
  ]
})
export class AdminModule { }
