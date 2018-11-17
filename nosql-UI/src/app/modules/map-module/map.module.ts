import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {GMapModule} from 'primeng/gmap';
import { MapComponent } from './map-component/map.component';

import {FormsModule} from '@angular/forms';
import {MapService} from './map.service';
import {
  CheckboxModule,
  CodeHighlighterModule,
  DialogModule,
  InputTextModule,
  MessageService,
  TabViewModule
} from 'primeng/primeng';
import {ToastModule} from 'primeng/toast';

@NgModule({
  imports: [
    CommonModule,
    GMapModule,
    FormsModule,
    ToastModule,
    InputTextModule,
    CheckboxModule,
    DialogModule,
    TabViewModule,
    CodeHighlighterModule
  ],
  declarations: [MapComponent],
  entryComponents: [MapComponent],
  exports: [MapComponent],
  providers: [
    MapService, MessageService
  ]

})
export class MapModule { }
