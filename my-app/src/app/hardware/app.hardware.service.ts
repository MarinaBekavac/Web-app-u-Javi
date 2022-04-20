import { Injectable } from '@angular/core';
import { Hardware } from '../hardware';
import { HARDWARE } from '../mock-hardware';
import { Observable, of } from "rxjs";

@Injectable({
providedIn: 'root'
})

export class HardwareService {

constructor() { }

getStudents(): Observable<Hardware[]> {
return of(HARDWARE);
}

}