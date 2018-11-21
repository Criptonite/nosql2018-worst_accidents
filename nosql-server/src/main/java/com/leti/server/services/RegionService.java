package com.leti.server.services;

import com.leti.server.entities.Region;
import com.leti.server.repositories.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionsRepository regionsRepository;

    @Autowired
    public RegionService(RegionsRepository regionsRepository) {
        this.regionsRepository = regionsRepository;
    }

    public List<Region> getAll(){
        return regionsRepository.findAll();
    }

    public Region addRegion(Region region) {
        return regionsRepository.insert(region);
    }

    public boolean isRegionExists(String region) {
        return regionsRepository.existsByName(region);
    }
}
