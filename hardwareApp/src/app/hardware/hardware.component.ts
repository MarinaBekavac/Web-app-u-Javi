import { Component, OnInit } from '@angular/core';
import { HardwareServiceComponent } from '../hardware.service/hardware.service.component';
import { Hardware } from '../models/hardware';

@Component({
  selector: 'app-hardware',
  templateUrl: './hardware.component.html',
  styleUrls: ['./hardware.component.css']
})
export class HardwareComponent implements OnInit {

  hardware!: Hardware[];
  selectedHardware!: Hardware;

  constructor(private hardwareService: HardwareServiceComponent) { }

  //constructor() { }

  ngOnInit(): void {
    this.getHardware();
  }

  getHardware(): void {
    this.hardwareService.getHardware()
    .subscribe(hardware => this.hardware = hardware);
    }

  onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
    } 

}
