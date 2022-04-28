import { error } from '@angular/compiler/src/util';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { HardwareServiceComponent } from '../hardware.service/hardware.service';
import { HardwareComponent } from '../hardware/hardware.component';
import { Hardware } from '../models/hardware';
import { Type } from '../models/type';

@Component({
  selector: 'app-hardware-add',
  templateUrl: './hardware.add.component.html',
  styleUrls: ['./hardware.add.component.css']
})
export class HardwareAddComponent implements OnInit {

  hardware: Hardware = {
    code: "",
    name: "",
    price: 0,
    type: Type.CPU,
    onStorage: 0
  };
  submitted = false;
  enumKeys = Object.values(Type);

  code!: string;
  name!: string;
  price!: number;
  hardwareType!: Type;
  onStorage!: number;

  constructor(private hardwareService: HardwareServiceComponent, private hardwareComponent: HardwareComponent) { }

  ngOnInit(): void {
  }

  saveHardware(): void {
    const data = {
      code: this.hardware.code,
      name: this.hardware.name,
      price: this.hardware.price,
      type: this.hardware.type,
      onStorage: this.hardware.onStorage
    };

    console.log(data);
    this.hardwareService.addHardware(data)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  addHardware(){

    console.log("Hardware : ", this.hardware);
    console.log("Type: ", this.hardwareType);

    const data = {
      code: this.hardware.code,
      name: this.hardware.name,
      price: this.hardware.price,
      type: this.hardwareType,
      onStorage: this.hardware.onStorage
    };

    console.log(data);
    this.hardwareService.addHardware(data)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
    this.hardwareComponent.getHardware();
    this.hardwareComponent.getHardware();
  }

}
