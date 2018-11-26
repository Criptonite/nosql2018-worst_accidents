package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeathTsDependencyStat implements ReportInfo {
    private Map<String, DeathTsDependency> deathTsByRegions;

    public void addRegionStat(String region, DeathTsDependency value) {
        deathTsByRegions.put(region, value);
    }
}
