package com.leti.server.controllers;

import com.leti.server.entities.RegionWithAccidents;
import com.leti.server.repositories.RegionsWithAccidentsRepository;
import com.leti.server.services.RegionWithAccientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
@RequestMapping("/accidents")
public class RegionWithAccidentsController {

    private RegionWithAccientsService regionWithAccientsService;

    @Autowired
    public RegionWithAccidentsController(RegionWithAccientsService regionWithAccientsService) {
        this.regionWithAccientsService = regionWithAccientsService;
    }

    @RequestMapping(method = GET)
    public List<RegionWithAccidents> getAllAccidents(){
        return regionWithAccientsService.getAll();
    }
}
