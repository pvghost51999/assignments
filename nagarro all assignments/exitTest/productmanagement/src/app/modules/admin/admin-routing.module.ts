import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthguardGuard } from 'src/app/authguard.guard';
import { ApproveproductComponent } from './components/approveproduct/approveproduct.component';
import { ProductsComponent } from './components/products/products.component';
import { ReviewComponent } from './components/review/review.component';

const routes: Routes = [
  {
    path:'products', component:ProductsComponent,canActivate:[AuthguardGuard]
    
  },
  {
    path:'review', component:ReviewComponent,canActivate:[AuthguardGuard]
    
  },
  {
    path:'approve', component:ApproveproductComponent,canActivate:[AuthguardGuard]
    
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
