import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HardwareDetailsComponent } from './hardware.details/hardware.details.component';
import { HardwareComponent } from './hardware/hardware.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { HardwareAddComponent } from './hardware.add/hardware.add.component';
import { ReviewComponent } from './review/review.component';
import { ReviewDetailsComponent } from './review.details/review.details.component';

@NgModule({
  declarations: [
    AppComponent,
    HardwareComponent,
    HardwareDetailsComponent,
    HardwareAddComponent,
    ReviewComponent,
    ReviewDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [HardwareComponent, HardwareDetailsComponent, HardwareAddComponent, ReviewComponent, ReviewDetailsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
