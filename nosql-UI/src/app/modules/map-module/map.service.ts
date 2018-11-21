import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Accident} from '../../models/accident';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  constructor() { }

  private accidents: Accident[];
  private _data = new BehaviorSubject(this.accidents);

  setAccident(accidentData: Accident[]) {
    if (accidentData && accidentData.length) {  this._data.next(accidentData); }
  }

  subscribe = async (func) => {
    return this._data.subscribe(func);
  }
}
