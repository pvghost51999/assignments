import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmationdailogComponent } from './confirmationdailog.component';

describe('ConfirmationdailogComponent', () => {
  let component: ConfirmationdailogComponent;
  let fixture: ComponentFixture<ConfirmationdailogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmationdailogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmationdailogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
