import {Component, OnInit} from '@angular/core';
import {ApiService} from './api.service';
import {Type} from './models/accident-type';
import {Region} from './models/region';
import {MapService} from './modules/map-module/map.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  types: Type[];
  regions: Region [];
  selectedType: Type;
  selectedRegion: Region;
  year: number;

  constructor(private apiService: ApiService, private mapService: MapService) {
  }

  ngOnInit() {
    this.selectedRegion = null;
    this.year = 2018;
    this.getRegions();
    this.getType();
  }

  getRegions(): void {
    this.apiService.getAllRegions().subscribe(regions => {
      this.regions = regions;
      if (this.regions && this.regions.length) {
        this.selectedRegion = this.regions[0];
      }
    });
  }

  getType(): void {
    this.apiService.getAllTypes().subscribe(types => this.types = types);
  }

  getAccidents(): void {
    this.apiService.getAccidents(this.selectedRegion.name, this.year, this.selectedType ? this.selectedType.typeName : null)
      .subscribe(accidents => {
        this.mapService.setAccident(accidents);
      });
  }
}
