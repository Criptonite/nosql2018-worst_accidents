package com.leti.server.controllers;

import com.leti.server.entities.City;
import com.leti.server.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController()
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(method = GET, value = "/all")
    public List<City> getAll() {
        return cityService.getAll();
    }

    @RequestMapping(method = GET)
    public City get(@RequestParam(value = "name") String name) {
        return cityService.getByName(name);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> add(@RequestBody City city){
        City saved = cityService.save(city);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(method = DELETE)
    public ResponseEntity<?>remove(@RequestParam(value = "id") String id){
        City removingCity = cityService.getById(id);
        cityService.remove(removingCity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
