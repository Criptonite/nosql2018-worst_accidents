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

    @RequestMapping(method = GET, value = "/city")
    public City get(@RequestParam(value = "name") String name) {
        return cityService.getByName(name);
    }

    @RequestMapping(method = POST, value = "/add")
    public ResponseEntity<?> add(@RequestBody City city){
        City saved = cityService.save(city);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(method = DELETE, value = "/remove")
    public ResponseEntity<?>remove(@RequestBody City city){
        cityService.remove(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
