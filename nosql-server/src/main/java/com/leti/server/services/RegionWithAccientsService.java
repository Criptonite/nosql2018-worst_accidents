package com.leti.server.services;

import com.leti.server.entities.RegionWithAccidents;
import com.leti.server.repositories.RegionsWithAccidentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionWithAccientsService {

    private RegionsWithAccidentsRepository regionsWithAccidentsRepository;

    @Autowired
    public RegionWithAccientsService(RegionsWithAccidentsRepository regionsWithAccidentsRepository) {
        this.regionsWithAccidentsRepository = regionsWithAccidentsRepository;
    }

    public List<RegionWithAccidents> getAll(){
        return regionsWithAccidentsRepository.findAll();
    }
}
