import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of, tap } from 'rxjs';
import { HardwareServiceComponent } from '../hardware.service/hardware.service';
import { Type } from '../models/type';
import { Hardware } from './../models/hardware';

@Component({
  selector: 'app-hardware-details',
  templateUrl: './hardware.details.component.html',
  styleUrls: ['./hardware.details.component.css']
})
export class HardwareDetailsComponent implements OnInit {

  /*@Input()
  hardware!: Hardware;

  constructor() { }

  ngOnInit(): void {
  }*/

  @Input()
  hardware: Hardware = {
    code: "",
    name: "",
    price: 0,
    type: Type.CPU,
    onStorage: 0
  };

  @Input() viewMode = false;


  ngOnInit(): void {
    if (!this.viewMode) {
      this.getHardwareByCode(this.route.snapshot.params["code"]);
    }
  }

  private hardwareUrl = 'http://localhost:8080/hardware';
  httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private hardwareService: HardwareServiceComponent,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  getHardwareByCode(code: string): void {
    /*const url = `${this.hardwareUrl}/${code}`;
    return this.http.get<Hardware>(url)
    .pipe(
      tap((newHardware: Hardware) => this.hardware=newHardware),
      catchError(this.handleError<Hardware>('getHardwareByCode')));*/
      this.viewMode = true;
      this.hardwareService.getHardwareByCode(code).subscribe({
        next: (data) => {
          this.hardware = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    }

  deleteHardware(): void {
      this.hardwareService.deleteHardware(this.hardware.code)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.router.navigate(['/hardware']);
          },
          error: (e) => console.error(e)
        });
    }
  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
    console.error(operation);
    console.error(error);
    return of(result as T);
    };
    }

}
