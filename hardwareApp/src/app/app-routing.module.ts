import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HardwareComponent } from './hardware/hardware.component';
import { HardwareDetailsComponent } from './hardware.details/hardware.details.component';
import { ReviewComponent } from './review/review.component';
import { ReviewDetailsComponent } from './review.details/review.details.component';

const routes: Routes = [
  { path: 'hardware', component: HardwareComponent },
  { path: 'hardware/:code', component: HardwareDetailsComponent },
  { path: 'review/:code/:id', component: ReviewDetailsComponent }
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
