import { Component, OnInit } from '@angular/core';
import { Hardware } from '../hardware';
import { HardwareService} from "./app.hardware.service";

@Component({
  selector: 'app-hardware-new',
  templateUrl: './hardware.component.html',
  styleUrls: ['./hardware.component.css']
})
export class HardwareComponentNew implements OnInit {

  hardware!: Hardware[];
  selectedHardware!: Hardware;

  constructor(private hardwareService: HardwareService) { }

  //constructor() { }

  ngOnInit(): void {
    this.getHardware();
  }

  getHardware(): void {
    this.hardwareService.getStudents()
    .subscribe(hardware => this.hardware = hardware);
    }

  onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
    }  

}
