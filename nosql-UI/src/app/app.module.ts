import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MapModule} from './modules/map-module/map.module';
import {ApiService} from './api.service';
import {DropdownModule} from 'primeng/dropdown';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {SpinnerModule} from 'primeng/spinner';
import {ButtonModule} from 'primeng/button';
import {FormsModule} from '@angular/forms';
import {TriStateCheckboxModule} from 'primeng/tristatecheckbox';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    HttpClientModule,
    MapModule,
    DropdownModule,
    FormsModule,
    SpinnerModule,
    ButtonModule,
    TriStateCheckboxModule
  ],
  providers: [
    ApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
