import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HardwareDetailsComponent } from './hardware.details/hardware.details.component';
import { HardwareComponent } from './hardware/hardware.component';

@NgModule({
  declarations: [
    AppComponent,
    HardwareComponent,
    HardwareDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [HardwareComponent, HardwareDetailsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
