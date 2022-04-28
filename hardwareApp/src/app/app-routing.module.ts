import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HardwareComponent } from './hardware/hardware.component';
import { HardwareDetailsComponent } from './hardware.details/hardware.details.component';
import { HardwareServiceComponent } from './hardware.service/hardware.service';
import { ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  { path: 'hardware', component: HardwareComponent },
  { path: 'hardware/:code', component: HardwareDetailsComponent }
  ];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
    ]
})
export class AppRoutingModule { }
