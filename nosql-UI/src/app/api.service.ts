import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

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

  private citiesListUrl = '/citiesList';
  private accidentsUrl = '/accidents';

  getAllCities(): Observable<any> {
    return this.httpClient.get(this.citiesListUrl);
  }

  getAccidents(selectedCity: string, year, withPedestrian?: string): Observable<any> {
    let queryParams = new HttpParams()
      .set('selectedCity', selectedCity)
      .set('year', year);
    if (withPedestrian !== null) {
      queryParams = queryParams.append('withPedestrian', withPedestrian.toString());
    }
    console.log(queryParams.toString());
    return this.httpClient.get(this.accidentsUrl, {params: queryParams});
  }
}
