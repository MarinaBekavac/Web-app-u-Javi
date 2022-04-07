import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Hardware.ServiceComponent } from './hardware.service.component';

describe('Hardware.ServiceComponent', () => {
  let component: Hardware.ServiceComponent;
  let fixture: ComponentFixture<Hardware.ServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Hardware.ServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Hardware.ServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
