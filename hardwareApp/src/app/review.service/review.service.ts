import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private reviewUrl = 'http://localhost:8080/review';
  httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(
  private http: HttpClient
  ) { }

  getAllReviews(): Observable<Review[]> {
    return this.http.get<Review[]>(this.reviewUrl);
  }

  getReviewByHardwareCode(code: string): Observable<Review[]> {
    const url = `${this.reviewUrl}/${code}`;
    return this.http.get<Review[]>(url);
  }

  getReviewById(id: number): Observable<Review>{
    const url = `${this.reviewUrl}/getReview/${id}`;
    return this.http.get<Review>(url);
  }

  deleteReviewById(id: number): Observable<Review>{
    const url = `${this.reviewUrl}/deleteReview/${id}`;
    return this.http.delete<Review>(url, this.httpOptions);
  }
  

}
