import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Hardware.DetailsComponent } from './hardware.details.component';

describe('Hardware.DetailsComponent', () => {
  let component: Hardware.DetailsComponent;
  let fixture: ComponentFixture<Hardware.DetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Hardware.DetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Hardware.DetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
