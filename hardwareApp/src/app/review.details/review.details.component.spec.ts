import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Review.DetailsComponent } from './review.details.component';

describe('Review.DetailsComponent', () => {
  let component: Review.DetailsComponent;
  let fixture: ComponentFixture<Review.DetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Review.DetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Review.DetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
