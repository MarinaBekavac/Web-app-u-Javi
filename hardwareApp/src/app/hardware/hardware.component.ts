import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HardwareServiceComponent } from '../hardware.service/hardware.service.component';
import { Hardware } from '../models/hardware';
import { Type } from '../models/type';
import { HardwareDetailsComponent } from '../hardware.details/hardware.details.component';

@Component({
  selector: 'app-hardware',
  templateUrl: './hardware.component.html',
  styleUrls: ['./hardware.component.css']
})
export class HardwareComponent implements OnInit {

  hardware!: Hardware[];
  selectedHardware!: Hardware;
  type! : Type;
  enumKeys = Object.values(Type);

  //constructor(private hardwareService: HardwareServiceComponent) { }

  //constructor() { }

  //zad 3
  /*ngOnInit(): void {
    this.getHardware();
  }

  getHardware(): void {
    this.hardwareService.getHardware()
    .subscribe(hardware => this.hardware = hardware);
    }

  onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
    } */

    constructor( private hardwareService: HardwareServiceComponent, private hardwareDetails:  HardwareDetailsComponent) {}

    ngOnInit(): void {
      this.getHardware();
      this.hardwareDetails.viewMode=false;
    }

    getHardware(): void {
      this.hardwareService.getHardwares()
      .subscribe(hardware => {
        this.hardware = hardware as Hardware[]
    });
    }


    onSelect(hardware: Hardware): void {
      this.selectedHardware = hardware;
      this.hardwareDetails.getHardwareByCode(hardware.code);
      }

    showDetails(code: string): void{
      this.hardwareDetails.getHardwareByCode(code);
    }

    add(code: string, name: string, price: number, type: Type, onStorage: number): void {
      code = code.trim();
      name = name.trim();
      if (!code || ! name || !price || !type || !onStorage) { return; }
      this.hardwareService.addHardware({ code, name, price, type, onStorage } as Hardware)
      .subscribe(hardwareItem => {
      this.hardware.push(hardwareItem);});
      }
      

}
