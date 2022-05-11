import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HardwareServiceComponent } from '../hardware.service/hardware.service';
import { Hardware } from '../models/hardware';
import { Rating } from '../models/rating';
import { Review } from '../models/review';
import { Type } from '../models/type';
import { ReviewService } from '../review.service/review.service';

@Component({
  selector: 'app-review-details',
  templateUrl: './review.details.component.html',
  styleUrls: ['./review.details.component.css']
})
export class ReviewDetailsComponent implements OnInit {

  /*hardware: Hardware = {
    code: "",
    name: "",
    price: 0,
    type: Type.CPU,
    onStorage: 0
  };*/

  hardwareCode!: string;

  /*review: Review ={
    id: 0,
    hardwareId: 0,
    title: "",
    description: "",
    rating: Rating.one_star
  };*/
  review!: Review;

  @Input() viewMode = false;

  httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private reviewServices: ReviewService,
    private hardwareService: HardwareServiceComponent,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  
  /*ngOnInit(): void {
    if (!this.viewMode) {
      console.log("In init, view: ", this.viewMode);
      this.getReviewById(this.review.id);
    }
  }

  getReviewById(id: number): void {
      this.viewMode = true;
      this.reviewServices.getReviewById(id).subscribe({
        next: (data) => {
          this.review = data;
          this.viewMode = true;
          console.log("View: ", this.viewMode)
          console.log(this.review);
        },
        error: (e) => console.error(e)
      });
    }*/

    ngOnInit(): void {
      if (!this.viewMode) {
        console.log("In init, view: ", this.viewMode);
        this.getReviewById(this.route.snapshot.params["id"]);
        this.hardwareCode = this.route.snapshot.params["code"];
        console.log("Review details component: Review after loading: ", this.review);
        console.log("Review details component: Hardware code: ", this.hardwareCode);
      }
    }
  
    getReviewById(id: number): void {
        this.viewMode = true;
        this.reviewServices.getReviewById(id).subscribe({
          next: (data) => {
            this.review = data;
            this.viewMode = true;
            console.log("View: ", this.viewMode)
            console.log("Review: ", this.review);
          },
          error: (e) => console.error(e)
        });
      }

    /*deleteReview(id: number): void {
      console.log("Deleting review with id ", id);
      this.getHardwareById(this.review.hardwareId);
      this.reviewServices.deleteReviewById(id);
      console.log("Hardware code in deleting hardware: ", this.hardware.code);
      this.router.navigate([`hardware/${this.hardware.code}`]);
    }

    getHardwareById(id: number): void{
      this.hardwareService.getHardwareById(id).subscribe({
        next: (data) => {
          this.hardware = data;
          console.log("Hardware: ", this.hardware);
        },
        error: (e) => console.error(e)
      })
    }*/

    /*deleteReview(id: number): void {
      console.log("Deleting review with id ", id);
      this.reviewServices.deleteReviewById(id);
      console.log("Hardware code in deleting hardware: ", this.hardwareCode);
      this.router.navigate([`hardware/${this.hardwareCode}`]);
    }*/

    deleteReview(id: number): void {
      console.log("Deleting review with id ", id);
      console.log("Hardware code in deleting hardware: ", this.hardwareCode);
      this.reviewServices.deleteReviewById(this.review.id)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.router.navigate([`hardware/${this.hardwareCode}`]);
          },
          error: (e) => console.error(e)
        });
    }

    getHardwareById(id: number): string{
      let hardwareCode = "";
      this.hardwareService.getHardwareById(id).subscribe({
        next: (data) => {
          console.log("Hardware: ", data);
          hardwareCode = data.code;
        },
        error: (e) => console.error(e)
      })
      return hardwareCode;
    }

}
