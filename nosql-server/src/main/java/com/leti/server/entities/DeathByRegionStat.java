package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class DeathByRegionStat implements ReportInfo {
    private Map<String, Integer> deathByRegions;

    public DeathByRegionStat() {
        deathByRegions = new HashMap<>();
    }

    public void addRegionStat(String region, Integer amount) {
        deathByRegions.put(region, amount);
    }
}
