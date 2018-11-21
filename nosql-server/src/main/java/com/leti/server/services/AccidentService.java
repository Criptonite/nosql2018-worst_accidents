package com.leti.server.services;

import com.leti.server.entities.Accident;
import com.leti.server.entities.Region;
import com.leti.server.entities.Type;
import com.leti.server.repositories.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {

    private AccidentRepository accidentRepository;
    private RegionService regionService;
    private TypeService typeService;

    @Autowired
    public AccidentService(AccidentRepository accidentRepository, RegionService regionService, TypeService typeService) {
        this.accidentRepository = accidentRepository;
        this.regionService = regionService;
        this.typeService = typeService;
    }

    public List<Accident> getAll() {
        return accidentRepository.findAll();
    }

    public List<Accident> getAccidentsByType(String type, String year) {
        return accidentRepository.findAccidentByTypeAndDateEndingWith(type, year);
    }

    public List<Accident> getAccidentsByRegion(String region, String year) {
        return accidentRepository.findAccidentByRegionAndDateEndingWith(region, year);
    }

    public List<Accident> getAccidentsByRegionAndType(String region, String type, String year) {
        return accidentRepository.findAccidentByRegionAndTypeAndDateEndingWith(region, type, year);
    }

    public Accident addAccident(Accident accident) {
        if (!typeService.isTypeExists(accident.getType())) {
            typeService.addType(new Type(accident.getType()));
        }

        if (!regionService.isRegionExists(accident.getRegion())) {
            regionService.addRegion(new Region(accident.getCode(), accident.getRegion()));
        }
        return accidentRepository.insert(accident);
    }
}
