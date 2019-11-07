import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class CarService {
 public API = '//52.146.59.6/api/v1';
  public STUDENT_API = this.API + '/cars';
 public CAR_API = this.API + '/car';
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
//     const headerDict = {
//   'Content-Type' : 'application/json',
//    'Accept' : 'application/json',
//   'Access-Control-Allow-Headers' : 'Content-Type',
//     };

// const requestOptions = {                                                                                                                                                                                 
//   headers: new HttpHeaders(headerDict), 
// };


    return this.http.get( this.STUDENT_API);
  }

  get(id: string) {
    return this.http.get(this.CAR_API + '/' + id);
  }

  save(car: any): Observable<any> {
    let result: Observable<any>;
    if (car.href) {
      result = this.http.put(car.href, car);
    } else {
      result = this.http.post(this.CAR_API, car);
    }
    return result;
    return null;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
