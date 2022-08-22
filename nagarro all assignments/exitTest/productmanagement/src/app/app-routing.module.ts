import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './modules/user/components/login/login.component';
import { RegistrationComponent } from './modules/user/components/registration/registration.component';

const routes: Routes = [
  {
    path:'', component:HomeComponent
  },

  {
    path:'login', component:LoginComponent
  },

  
  {
    path:'user', loadChildren:()=> import('./modules/user/user.module').
    then((mod)=>mod.UserModule)
  }
  ,
  {
    path:'admin', loadChildren:()=> import('./modules/admin/admin.module').
    then((mod)=>mod.AdminModule)
  }
,
  {
    path:'register', component:RegistrationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
