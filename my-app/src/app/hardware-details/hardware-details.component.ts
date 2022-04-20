import { Component, OnInit, Input } from '@angular/core';
import { Hardware } from '../hardware';

@Component({
  selector: 'app-hardware-details',
  templateUrl: './hardware-details.component.html',
  styleUrls: ['./hardware-details.component.css']
})
export class HardwareDetailsComponent implements OnInit {

  @Input()
  hardware!: Hardware;

  constructor() { }

  ngOnInit(): void {
  }

}
