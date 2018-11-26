package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManWomanStat implements ReportInfo {

    private Map<String, ManWoman> guiltyByRegions;

    public void addRegionStat(String region, ManWoman value) {
        guiltyByRegions.put(region, value);
    }
}
