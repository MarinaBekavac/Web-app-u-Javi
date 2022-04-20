import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Hardware.AddComponent } from './hardware.add.component';

describe('Hardware.AddComponent', () => {
  let component: Hardware.AddComponent;
  let fixture: ComponentFixture<Hardware.AddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Hardware.AddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Hardware.AddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
