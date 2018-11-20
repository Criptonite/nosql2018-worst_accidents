package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accident {
    String kartId;
    String date;
    String time;
    String district;
    String type;
    int tsCount;
    int uchCount;
    DtpInfo dtpInfo;

}
