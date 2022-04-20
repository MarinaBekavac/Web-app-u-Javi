import { Component, OnInit } from '@angular/core';
import { Hardware } from '../hardware';
import { HardwareService} from "./app.hardware.service";

@Component({
selector: 'app-hardware',
templateUrl: '../app.component.html',
styleUrls: ['../app.component.css']
})

export class HardwareComponent implements OnInit {

title = 'my-app';
hardware!: Hardware[];
selectedHardware!: Hardware;

constructor(private hardwareService: HardwareService) { }

ngOnInit(): void {
    this.getStudents();
    }
    getStudents(): void {
    this.hardwareService.getStudents()
    .subscribe(hardware => this.hardware = hardware);
    }
    onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
    }
}    