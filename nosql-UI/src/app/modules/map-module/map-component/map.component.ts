import { Component, OnInit, ViewChild } from '@angular/core';
import {MessageService} from 'primeng/api';
import {MapService} from '../map.service';
import {Accident} from '../../../models/accident';

declare var google: any;

@Component({
  selector: 'app-map-component',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  options: any;

  overlays: any[];

  dialogVisible: boolean;

  markerTitle: string;

  selectedPosition: any;

  infoWindow: any;

  draggable: boolean;

  private mapServiceSubscription: any;

  private accidents: Accident[];
  selectedAccident: Accident;
  shortInfoDialog: boolean;
  longInfoDialog: boolean;

  constructor(private messageService: MessageService, private mapService: MapService) {}

  @ViewChild('gmap')
  gMapComponent: any;

  ngOnInit() {
    this.options = {
      center: {lat: 36.890257, lng: 30.707417},
      zoom: 6
    };

    this.infoWindow = new google.maps.InfoWindow();
    this.mapServiceSubscription = this.mapService.subscribe(data => {
      if (data) {
        this.clear();
        this.accidents = data;
        if (data.length > 0) {
          data.forEach(accident => this.handleAccident(accident));
          const lastAccident = data[data.length - 1];
          this.setCenter(this.getLatFromAccident(lastAccident), this.getLngFromAccident(lastAccident));
        } else {
          this.messageService.add({severity: 'info', summary: 'Нет происшествий для выбраных параметров'});
        }
      }
    });
  }

  handleAccident(accident: Accident) {
    this.addMarker(this.getLatFromAccident(accident), this.getLngFromAccident(accident), accident.KartId);
  }

  openDetailedReport() {
    this.longInfoDialog = true;
  }

  getLatFromAccident(acc: Accident) {
    return acc.dtp_info.latitude;
  }

  getLngFromAccident(acc: Accident) {
    return acc.dtp_info.longitude;
  }

  handleOverlayClick(event) {
      const title = event.overlay.getTitle();
      this.selectAccidentById(event.overlay.getTitle());
      event.map.setCenter(event.overlay.getPosition());
      this.shortInfoDialog = true;
  }

  selectAccidentById (id: string): void {
    this.selectedAccident = this.accidents.find(accident => accident.KartId === id);
  }

  setCenter(lat, lng) {
    this.gMapComponent.getMap().setCenter(new google.maps.LatLng(lat, lng));
  }

  addMarker(lat, lng, title?) {
    this.overlays.push(
      new google.maps.Marker({
          position: {
              lat: lat,
              lng: lng
          },
          title: title,
          draggable: false
      }));
    this.markerTitle = null;
    this.dialogVisible = false;
  }

  clear() {
    this.overlays = [];
  }

}
