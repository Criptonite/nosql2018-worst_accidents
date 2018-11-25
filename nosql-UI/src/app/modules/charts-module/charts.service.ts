import {Injectable} from '@angular/core';
import {ChartsComponent} from './charts.component';
import {Region} from '../../models/region';
import {ChartsApiService} from './charts-api.service';

@Injectable()
export class ChartsService {

  private chartComponent: ChartsComponent;

  constructor(private chartsApiService: ChartsApiService) {
  }
}
