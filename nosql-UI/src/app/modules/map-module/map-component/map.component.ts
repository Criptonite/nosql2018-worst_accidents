import { Component, OnInit } from '@angular/core';
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

  constructor(private messageService: MessageService, private mapService: MapService) {}

  ngOnInit() {
    this.options = {
      center: {lat: 36.890257, lng: 30.707417},
      zoom: 5
    };

    this.initOverlays();

    this.infoWindow = new google.maps.InfoWindow();
    this.mapServiceSubscription = this.mapService.subscribe(data => {
      data.forEach(accident => this.handleAccident(accident));
    });
  }

  handleAccident(accident: Accident) {
    this.addMarker(accident.dtpInfo.latitude, accident.dtpInfo.longitude, accident.kartId);
  }

  handleOverlayClick(event) {
    const isMarker = event.overlay.getTitle !== undefined;

    if (isMarker) {
      const title = event.overlay.getTitle();
      this.infoWindow.setContent('' + title + '');
      this.infoWindow.open(event.map, event.overlay);
      event.map.setCenter(event.overlay.getPosition());

      this.messageService.add({severity: 'info', summary: 'Marker Selected', detail: title});
    } else {
      this.messageService.add({severity: 'info', summary: 'Shape Selected', detail: ''});
    }
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

  initOverlays() {
    if (!this.overlays || !this.overlays.length) {
      this.overlays = [
        new google.maps.Marker({position: {lat: 36.879466, lng: 30.667648}, title: 'Konyaalti'}),
        new google.maps.Marker({position: {lat: 36.883707, lng: 30.689216}, title: 'Ataturk Park'}),
        new google.maps.Marker({position: {lat: 36.885233, lng: 30.702323}, title: 'Oldtown'}),
        new google.maps.Polygon({paths: [
            {lat: 36.9177, lng: 30.7854}, {lat: 36.8851, lng: 30.7802}, {lat: 36.8829, lng: 30.8111}, {lat: 36.9177, lng: 30.8159}
          ], strokeOpacity: 0.5, strokeWeight: 1, fillColor: '#1976D2', fillOpacity: 0.35
        }),
        new google.maps.Circle({center: {lat: 36.90707, lng: 30.56533}, fillColor: '#1976D2', fillOpacity: 0.35, strokeWeight: 1, radius: 1500}),
        new google.maps.Polyline({path: [{lat: 36.86149, lng: 30.63743}, {lat: 36.86341, lng: 30.72463}], geodesic: true, strokeColor: '#FF0000', strokeOpacity: 0.5, strokeWeight: 2})
      ];
    }
  }

  zoomIn(map) {
    map.setZoom(map.getZoom() + 1);
  }

  zoomOut(map) {
    map.setZoom(map.getZoom() - 1);
  }

  clear() {
    this.overlays = [];
  }

}
