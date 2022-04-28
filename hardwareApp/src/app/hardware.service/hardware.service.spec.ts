import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HardwareServiceComponent } from './hardware.service';

describe('Hardware.ServiceComponent', () => {
  let component: HardwareServiceComponent;
  let fixture: ComponentFixture<HardwareServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HardwareServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HardwareServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
