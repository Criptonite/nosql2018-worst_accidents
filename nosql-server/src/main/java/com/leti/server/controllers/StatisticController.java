package com.leti.server.controllers;

import com.leti.server.entities.*;
import com.leti.server.services.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/statistic")
public class StatisticController {

    private static final int REPORT_DETH_DEPENDS_TS_AMOUNT = 0;
    private static final int REPORT_DETH_BY_REGIONS = 1;
    private static final int REPORT_ACCIDENT_DEPENDS_WOMAN = 2;

    private AccidentService accidentService;

    @Autowired
    public StatisticController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @RequestMapping(method = POST)
    public Map<Integer, ? extends ReportInfo> getReport(@RequestBody ReportBody body) {
        switch (body.getReportType()) {
            case REPORT_DETH_DEPENDS_TS_AMOUNT:
                Map<Integer, DeathTsDependencyStat> deathByTsAmount = new HashMap<>();
                body.getYears().forEach(year -> {
                    DeathTsDependencyStat deathInRegion = new DeathTsDependencyStat();
//                    body.getRegions().forEach(region -> deathInRegion.addRegionStat(region.getName(), accidentService.getDeathDependsTsCount(region, year)));
                    body.getRegions().forEach(region -> deathInRegion.addRegionStat(region.getName(), accidentService.getAccidentsWithDeath(region.getName(), year)
                            .stream()
                            .map(this::createDeathTsDependency)
                            .collect(Collectors.toList())));
                    deathByTsAmount.put(year, deathInRegion);
                });
                return deathByTsAmount;
            case REPORT_DETH_BY_REGIONS:
                Map<Integer, DeathByRegionStat> deathByRegions = new HashMap<>();
                body.getYears().forEach(year -> {
                    DeathByRegionStat deathInRegion = new DeathByRegionStat();
                    body.getRegions().forEach(region -> deathInRegion.addRegionStat(region.getName(), accidentService.getAccidentsWithDeathCount(region, year)));
                    deathByRegions.put(year, deathInRegion);
                });
                return deathByRegions;
            case REPORT_ACCIDENT_DEPENDS_WOMAN:
                Map<Integer, ManWomanStat> guiltyWomen = new HashMap<>();
                body.getYears().forEach(year -> {
                    ManWomanStat inRegion = new ManWomanStat();
                    body.getRegions().forEach(region -> inRegion.addRegionStat(region.getName(), createManWoman(accidentService.getAccidentsByRegion(region.getName(), String.valueOf(year)))));
                    guiltyWomen.put(year, inRegion);
                });
                return guiltyWomen;
            default:
                throw new IllegalArgumentException();
        }
    }


    private int getAllDeathFromAccident(Accident accident) {
        DtpInfo dtpInfo = accident.getDtpInfo();
        int deadUch = (int) dtpInfo.getUchInfo()
                .stream()
                .filter(uchInfo -> uchInfo.getState().startsWith("Скончался"))
                .count();
        int deadInTs = dtpInfo.getTsInfo()
                .stream()
                .mapToInt(info -> (int) info.getUchInfo()
                        .stream()
                        .filter(uchInfo -> uchInfo.getState().startsWith("Скончался"))
                        .count())
                .sum();
        return deadUch + deadInTs;
    }

    private DeathTsDependency createDeathTsDependency(Accident accident) {
        DeathTsDependency dtd = new DeathTsDependency();
        dtd.setTsCount(accident.getDtpInfo().getTsInfo().size());
        dtd.setDeathCount(getAllDeathFromAccident(accident));
        return dtd;
    }

    private ManWoman createManWoman(List<Accident> accidents) {
        int guiltyManUch = (int) accidents
                .stream()
                .flatMap(accident -> accident.getDtpInfo().getUchInfo().stream())
                .filter(info -> "Мужской".equals(info.getGender()))
                .filter(info -> !info.getNpdd().contains("Нет нарушений"))
                .count();
        int guiltyManTs = (int) accidents
                .stream()
                .flatMap(accident -> accident.getDtpInfo().getTsInfo().stream())
                .flatMap(tsInfo -> tsInfo.getUchInfo().stream())
                .filter(info -> "Мужской".equals(info.getGender()))
                .filter(info -> !info.getNpdd().contains("Нет нарушений"))
                .count();
        int guiltyMan = guiltyManUch + guiltyManTs;

        int guiltyWomanUch = (int) accidents
                .stream()
                .flatMap(accident -> accident.getDtpInfo().getUchInfo().stream())
                .filter(info -> "Женский".equals(info.getGender()))
                .filter(info -> !info.getNpdd().contains("Нет нарушений"))
                .count();
        int guiltyWomanTs = (int) accidents
                .stream()
                .flatMap(accident -> accident.getDtpInfo().getTsInfo().stream())
                .flatMap(tsInfo -> tsInfo.getUchInfo().stream())
                .filter(info -> "Женский".equals(info.getGender()))
                .filter(info -> !info.getNpdd().contains("Нет нарушений"))
                .count();
        int guiltyWoman = guiltyWomanUch + guiltyWomanTs;
        return new ManWoman(guiltyMan, guiltyWoman);
    }
}
