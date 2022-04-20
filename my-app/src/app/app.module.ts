import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HardwareDetailsComponent } from './hardware-details/hardware-details.component';
import { HardwareComponentNew } from './hardware/hardware.component';
import { HardwareComponent } from './hardware/app.hardware.component';

@NgModule({
  declarations: [
    AppComponent,
    HardwareComponent,
    HardwareComponentNew,
    HardwareDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [HardwareComponentNew, HardwareDetailsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
