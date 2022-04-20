import { Component, Injectable, OnInit } from '@angular/core';
import { catchError, Observable, of, tap } from 'rxjs';
import { Hardware } from '../models/hardware';
import { HARDWARE } from '../models/mock-hardware';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
  })
export class HardwareServiceComponent {

  //zad 3
 /* constructor() { }

  getHardware(): Observable<Hardware[]> {
  return of(HARDWARE);
  }*/

  private hardwareUrl = 'http://localhost:8080/hardware';
  httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(
  private http: HttpClient
  ) { }

  /*getHardwares(): Observable<Hardware[]> {
    return this.http.get<Hardware[]>(this.hardwareUrl)
    .pipe(
      tap(_ => console.log('fetched hardware')),
      catchError(this.handleError<Hardware[]>('getHardware', [])));
    }

  getHardwareByCode(code: string): Observable<Hardware> {
    const url = `${this.hardwareUrl}/${code}`;
    return this.http.get<Hardware>(url);
    }

  addHardware(hardware: Hardware): Observable<Hardware> {
    const url = `${this.hardwareUrl}/"addItem"`;
    return this.http.post<Hardware>(url, hardware, this.httpOptions)
    .pipe(
      tap((newHardware: Hardware) => console.log(`added hardware w/ CODE=${newHardware.code}`)),
      catchError(this.handleError<Hardware>('addHardware')));
    }

  updateHardware(hardware: Hardware): Observable<any> {
    const url = `${this.hardwareUrl}/"editItem"/${hardware.code}`;
    return this.http.put(url, hardware, this.httpOptions)
    .pipe(
      tap(_ => console.log(`updated hardware code=${hardware.code}`)),
      catchError(this.handleError<any>('updateHardware')));
    }

  deleteHardware(hardware: Hardware | string): Observable<Hardware> {
    const code = typeof hardware === 'string' ? hardware : hardware.code;
    const url = `${this.hardwareUrl}/"deleteItem"/${code}`;
    return this.http.delete<Hardware>(url, this.httpOptions)
    .pipe(
      tap(_ => console.log(`deleted hardware code=${code}`)),
      catchError(this.handleError<Hardware>('deleteHardware'))  );
    }

    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
      };
      }*/

  getHardwares(): Observable<Hardware[]> {
          return this.http.get<Hardware[]>(this.hardwareUrl);
        }
    
  getHardwareByCode(code: string): Observable<Hardware> {
          const url = `${this.hardwareUrl}/${code}`;
          return this.http.get<Hardware>(url);
        }
    
  addHardware(hardware: Hardware): Observable<Hardware> {
          const url = `${this.hardwareUrl}/addItem`;
          return this.http.post<Hardware>(url, hardware, this.httpOptions);
        }
    
  updateHardware(hardware: Hardware): Observable<any> {
          const url = `${this.hardwareUrl}/"editItem"/${hardware.code}`;
          return this.http.put(url, hardware, this.httpOptions);
        }
    
  deleteHardware(hardware: Hardware | string): Observable<Hardware> {
          const code = typeof hardware === 'string' ? hardware : hardware.code;
          const url = `${this.hardwareUrl}/deleteItem/${code}`;
          return this.http.delete<Hardware>(url, this.httpOptions);
        }


}




