package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtpInfo {
    List<String> sdor;
    List<String> ndu;
    String light;
    String weather;
    double longtitude;
    double latitude;
    List<TSInfo> tsInfo;
    List<UchInfo> uchInfo;
}
