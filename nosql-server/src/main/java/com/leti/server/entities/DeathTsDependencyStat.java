package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class DeathTsDependencyStat implements ReportInfo {
    private Map<String, List<DeathTsDependency>> deathTsByRegions;

    public DeathTsDependencyStat() {
        deathTsByRegions = new HashMap<>();
    }

    public void addRegionStat(String region, List<DeathTsDependency> value) {
        deathTsByRegions.put(region, value);
    }
}
