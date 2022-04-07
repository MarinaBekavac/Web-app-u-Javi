import { Component, Injectable, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Hardware } from '../models/hardware';
import { HARDWARE } from '../models/mock-hardware';


@Injectable({
  providedIn: 'root'
  })
export class HardwareServiceComponent {

  constructor() { }

  getHardware(): Observable<Hardware[]> {
  return of(HARDWARE);
  }

}




