import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthguardGuard } from 'src/app/authguard.guard';
import { AddproductComponent } from './components/addproduct/addproduct.component';
import { CommentsComponent } from './components/comments/comments.component';
import { LoginComponent } from './components/login/login.component';
import { ProductsComponent } from './components/products/products.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ReviewComponent } from './components/review/review.component';

const routes: Routes = [
{
  path:'products', component:ProductsComponent,canActivate:[AuthguardGuard]
  
}
,
{
  path:'review', component:ReviewComponent,canActivate:[AuthguardGuard]
  
},
{
  path:'comment', component:CommentsComponent,canActivate:[AuthguardGuard]
  
},
{
  path:'askreview', component:AddproductComponent,canActivate:[AuthguardGuard]
  
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
