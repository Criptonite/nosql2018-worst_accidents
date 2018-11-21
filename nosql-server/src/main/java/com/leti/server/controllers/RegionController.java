package com.leti.server.controllers;

import com.leti.server.entities.Region;
import com.leti.server.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
@RequestMapping("/regions")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @RequestMapping(method = GET)
    public List<Region> getAllRegions() {
        return regionService.getAll();
    }
}
