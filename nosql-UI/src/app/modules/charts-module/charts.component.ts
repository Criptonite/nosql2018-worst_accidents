import {Component, OnInit} from '@angular/core';
import {ChartsApiService} from './charts-api.service';
import {Region} from '../../models/region';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css'],
})
export class ChartsComponent  implements OnInit {

  chartType: string;
  chartTypes: any;
  pieData: any;
  barChartData: any;
  lineChartData: any;
  regions: Region [];
  years: any[];
  selectedRegions: Region [];
  selectedYears: number [];
  reportLoading = false;

  constructor (private chartApiService: ChartsApiService) {
  }

  ngOnInit(): void {
    this.getRegions();
    this.years = [
      {name: '2014', value: 2014},
      {name: '2015', value: 2015},
      {name: '2016', value: 2016},
      {name: '2017', value: 2017},
      {name: '2018', value: 2018},
    ];
    this.chartTypes = [
      {label: 'Pie Chart', value: 'firstType'},
      {label: 'Bar Chart', value: 'secondType'},
      {label: 'Line Chart', value: 'thirdType'}
    ];
    this.barChartData = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label: 'My First dataset',
          backgroundColor: '#42A5F5',
          borderColor: '#1E88E5',
          data: [65, 59, 80, 81, 56, 55, 40]
        },
        {
          label: 'My Second dataset',
          backgroundColor: '#9CCC65',
          borderColor: '#7CB342',
          data: [28, 48, 40, 19, 86, 27, 90]
        }
      ]
    };
    this.pieData = {
      labels: ['A', 'B', 'C'],
      datasets: [
        {
          data: [300, 50, 100],
          backgroundColor: [
            '#FF6384',
            '#36A2EB',
            '#FFCE56'
          ],
          hoverBackgroundColor: [
            '#FF6384',
            '#36A2EB',
            '#FFCE56'
          ]
        }]
    };
    this.lineChartData = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label: 'First Dataset',
          data: [65, 59, 80, 81, 56, 55, 40],
          fill: false,
          borderColor: '#4bc0c0'
        },
        {
          label: 'Second Dataset',
          data: [28, 48, 40, 19, 86, 27, 90],
          fill: false,
          borderColor: '#565656'
        }
      ]
    };
  }

  getRegions(): void {
    this.chartApiService.getAllRegions().subscribe(regions => {
      this.regions = regions;
    });
  }

  getReport(): void {
    this.reportLoading = true;
    this.chartApiService.getReport(this.chartType, this.selectedYears, this.selectedRegions).subscribe(report => {
      this.reportLoading = false;
    });
  }
}
