import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Labos6detailsComponent } from './labos6details.component';

describe('Labos6detailsComponent', () => {
  let component: Labos6detailsComponent;
  let fixture: ComponentFixture<Labos6detailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Labos6detailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Labos6detailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
