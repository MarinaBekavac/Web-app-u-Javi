import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Labos6detailsComponent } from '../labos6details/labos6details.component';
import { Rating } from '../models/rating';
import { Review } from '../models/review';
import { ReviewDetailsComponent } from '../review.details/review.details.component';
import { ReviewService } from '../review.service/review.service';

@Component({
  selector: 'app-labos6',
  templateUrl: './labos6.component.html',
  styleUrls: ['./labos6.component.css']
})
export class Labos6Component implements OnInit {

  ngOnInit(): void {
  }

  reviews!: Review[];
  selectedReview!: Review;
  hardwareCode!: string;
  desc!: string;
  review: Review ={
    id: 0,
    hardwareId: 0,
    title: "",
    description: "",
    rating: Rating.one_star
  };

  constructor(
    private reviewServices: ReviewService,
    private route: ActivatedRoute,
    private reviewDetails: ReviewDetailsComponent,
    private detailsLab: Labos6detailsComponent
  ) { }

    httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    findReviews(desc:string): void{
      /*const data = {
        desc: this.review.description,
      };
      
      this.reviewServices.findReviewsDyDecs(this.desc).subscribe({
        next: (data: Review[]) => {
          this.reviews = data;
          console.log("Labos6: desc to find: ", this.desc);
        },
        error: (e) => console.error(e)
      });*/

      this.reviewServices.findReviewsDyDecs(desc).subscribe({
        next: (data: Review[]) => {
          this.reviews = data;
          console.log("Labos6: desc to find: ", desc);
        },
        error: (e) => console.error(e)
      });
    }

    showDetails(id: number, hardwareId: number){
      this.detailsLab.getReviewDetaiks(id, hardwareId);
    }

}
