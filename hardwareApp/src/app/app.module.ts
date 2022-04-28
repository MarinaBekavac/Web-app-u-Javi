import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HardwareDetailsComponent } from './hardware.details/hardware.details.component';
import { HardwareComponent } from './hardware/hardware.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { Hardware } from './models/hardware';
import { HardwareAddComponent } from './hardware.add/hardware.add.component';

/*const routes: Routes = [
  { path: 'hardware', component: HardwareComponent },
  { path: 'hardware/:code', component: HardwareDetailsComponent }
  ];*/

@NgModule({
  declarations: [
    AppComponent,
    HardwareComponent,
    HardwareDetailsComponent,
    HardwareAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [HardwareComponent, HardwareDetailsComponent, HardwareAddComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
