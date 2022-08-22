import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from '../home/home.component';
import { LoginComponent } from 'src/app/modules/user/components/login/login.component';
import { SearchbarComponent } from '../searchbar/searchbar.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { NavbarComponent } from '../navbar/navbar.component';
import { RatingModule } from 'ng-starrating';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [HomeComponent,SearchbarComponent,NavbarComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RatingModule,
    NgbModule
  ],
  exports:[HomeComponent,SearchbarComponent,NavbarComponent]
})
export class HomemoduleModule { }
