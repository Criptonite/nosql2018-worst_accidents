import {Component, OnInit} from '@angular/core';
import {ApiService} from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  selectedCity: string;
  year: number;
  hasPedestrian: any;
  readonly cities = [
    {label: 'Saint-Petersburg', value: 'Saint-Petersburg'},
    {label: 'Moscow', value: 'Moscow'},
    {label: 'Ivanovo', value: 'Ivanovo'},
    {label: 'Tomsk', value: 'Tomsk'},
    {label: 'Novosibirsk', value: 'Novosibirsk'},
    {label: 'Simferopol', value: 'Simferopol'},
    {label: 'Vladivostok', value: 'Vladivostok'}
  ];

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    this.selectedCity = null;
    this.year = 2018;
    // this.apiService.getAllCities().subscribe(res => {
    //   console.log(res);
    // const city = new City('id', 'Spb', new MapLocation(123, 321), 1000);
    // this.cities.push(city);
    // });
  }

  getAccidents(): void {
    this.apiService.getAccidents(this.selectedCity, this.year, this.hasPedestrian !== undefined ? this.hasPedestrian : null)
      .subscribe(accidents => {
        console.log(accidents);
      });
  }
}
