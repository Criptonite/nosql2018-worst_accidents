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
public class TSInfo {
    String tsId;
    String type;
    String marka;
    String model;
    int g_v;
    String color;
    List<UchInfo> uchInfo;
}
