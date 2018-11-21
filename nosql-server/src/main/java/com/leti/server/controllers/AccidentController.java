package com.leti.server.controllers;

import com.leti.server.entities.Accident;
import com.leti.server.services.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController()
@RequestMapping("/accidents")
public class AccidentController {

    private AccidentService accidentService;

    @Autowired
    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @RequestMapping(method = GET, value = "/all")
    public List<Accident> getAllAccidents() {
        return accidentService.getAll();
    }

    @RequestMapping(method = GET, value = "/withType")
    public List<Accident> getAllAccidentsWithType(@RequestParam(value = "type") String type,
                                                  @RequestParam(value = "year") String year) {
        return accidentService.getAccidentsByType(type, year);
    }

    @RequestMapping(method = GET, value = "/withRegion")
    public List<Accident> getAllAccidentsInRegion(@RequestParam(value = "region") String region,
                                                  @RequestParam(value = "year") String year) {
        return accidentService.getAccidentsByRegion(region, year);
    }

    @RequestMapping(method = GET, value = "/withRegionAndType")
    public List<Accident> getAllAccidentsInRegionWithType(@RequestParam(value = "region") String region,
                                                          @RequestParam(value = "type") String type,
                                                          @RequestParam(value = "year") String year) {
        return accidentService.getAccidentsByRegionAndType(region, type, year);
    }

    @RequestMapping(method = POST, value = "/addAccident")
    public ResponseEntity<?> addAccident(@RequestBody Accident accident) {
        accidentService.addAccident(accident);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
