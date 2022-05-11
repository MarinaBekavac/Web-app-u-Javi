import { HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hardware } from '../models/hardware';
import { Review } from '../models/review';
import { ReviewDetailsComponent } from '../review.details/review.details.component';
import { ReviewService } from '../review.service/review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviews!: Review[];
  selectedReview!: Review;
  hardwareCode!: string;

  constructor(
    private reviewServices: ReviewService,
    private route: ActivatedRoute,
    private reviewDetails: ReviewDetailsComponent
  ) { }

    httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
  
  ngOnInit(): void {
      this.getReviewByHardwareCode(this.route.snapshot.params["code"]);
      this.hardwareCode = this.route.snapshot.params["code"];
      console.log("Rewiev Component: Fetched reviews: ", this.reviews);
      console.log("Review Component: Assignet hardware code: ", this.hardwareCode);
  }

  getReviewByHardwareCode(code: string): void {
    this.reviewServices.getReviewByHardwareCode(code).subscribe({
      next: (data: Review[]) => {
        this.reviews = data;
        console.log("Reviews: ", this.reviews);
      },
      error: (e) => console.error(e)
    });
  }

  showDetails(id: number): void{
    this.reviewDetails.getReviewById(id);
  }

  

}
