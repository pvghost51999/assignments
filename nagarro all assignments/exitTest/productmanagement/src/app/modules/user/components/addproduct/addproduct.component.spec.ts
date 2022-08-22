import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddproductComponent } from './addproduct.component';
import {MatDialogModule} from '@angular/material/dialog';
describe('AddproductComponent', () => {
  let component: AddproductComponent;
  let fixture: ComponentFixture<AddproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddproductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});