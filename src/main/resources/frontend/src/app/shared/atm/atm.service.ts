import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class AtmService {

  constructor(private http: HttpClient) {
  }

  getAtm(searchText: string): Observable<any> {
    return this.http.get('//localhost:8080/api/atm', { params: { search: searchText }});
  }
}