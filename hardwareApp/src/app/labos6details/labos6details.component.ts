import { HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HardwareServiceComponent } from '../hardware.service/hardware.service';
import { Hardware } from '../models/hardware';
import { Rating } from '../models/rating';
import { Review } from '../models/review';
import { Type } from '../models/type';
import { ReviewService } from '../review.service/review.service';

@Component({
  selector: 'app-labos6details',
  templateUrl: './labos6details.component.html',
  styleUrls: ['./labos6details.component.css']
})
export class Labos6detailsComponent implements OnInit {

  ngOnInit(): void {
    if (!this.viewMode) {
      this.getReviewDetaiks(this.route.snapshot.params["id"],this.route.snapshot.params["code"]);
    }
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
  
    constructor(
      private hardwareService: HardwareServiceComponent,
      private reviewService: ReviewService,
      private route: ActivatedRoute,
      private router: Router
    ) { }

  hardware: Hardware = {
    code: "",
    name: "",
    price: 0,
    type: Type.CPU,
    onStorage: 0
  };

  @Input() viewMode = false;

  @Input()
  review ={
    id: 0,
    hardwareId: 0,
    title: "",
    description: "",
    rating: Rating.one_star
  };

  getReviewDetaiks(id: number, hardwareId: number){

    this.viewMode = true;
      this.hardwareService.getHardwareById(hardwareId).subscribe({
        next: (data) => {
          this.hardware = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });

      this.viewMode = true;
      this.reviewService.getReviewById(id).subscribe({
        next: (dataa) => {
          this.review = dataa;
          console.log(dataa);
        },
        error: (e) => console.error(e)
      });

    }

}
