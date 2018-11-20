import {DtpInfo} from './dtp-info';

export class Accident {
  kartId: string;
  time: string;
  district: string;
  type: string;
  tsCount: number;
  uchCount: number;
  dtpInfo: DtpInfo;
}
