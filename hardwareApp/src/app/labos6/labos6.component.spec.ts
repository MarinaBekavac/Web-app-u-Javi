import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Labos6Component } from './labos6.component';

describe('Labos6Component', () => {
  let component: Labos6Component;
  let fixture: ComponentFixture<Labos6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Labos6Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Labos6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
