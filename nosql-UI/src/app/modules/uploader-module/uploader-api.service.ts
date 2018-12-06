import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Region} from '../../models/region';
import {Observable} from 'rxjs';
import {Accident} from '../../models/accident';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable()
export class UploaderApiService {

  private baseUrl = '/api';
  private addAccidentListUrl = '/accidents/addAccidentList';
  constructor(private httpClient: HttpClient) { }

  addAccident(accident: Accident[]): Observable<any> {
    return this.httpClient.post(this.baseUrl + this.addAccidentListUrl, accident, httpOptions);
  }
}
