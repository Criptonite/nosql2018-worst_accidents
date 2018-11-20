import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Region} from './models/region';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  private regionListUrl = '/regions';
  private accidentsUrl = '/accidents';
  private typesUrl = '/types';

  getAllRegions(): Observable<any> {
    return this.httpClient.get(this.regionListUrl);
  }

  getAllTypes(): Observable<any> {
    return this.httpClient.get(this.typesUrl);
  }

  getAccidents(selectedRegion: string, year, accidentType?: string): Observable<any> {
    let queryParams = new HttpParams()
      .set('selectedRegion', selectedRegion)
      .set('year', year);
    if (accidentType !== null) {
      queryParams = queryParams.append('type', accidentType.toString());
    }
    return this.httpClient.get(this.accidentsUrl, {params: queryParams});
  }
}
