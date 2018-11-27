package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ManWomanStat implements ReportInfo {

    private Map<String, ManWoman> guiltyByRegions;

    public ManWomanStat() {
        guiltyByRegions = new HashMap<>();
    }

    public void addRegionStat(String region, ManWoman value) {
        guiltyByRegions.put(region, value);
    }
}
