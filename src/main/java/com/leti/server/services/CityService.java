package com.leti.server.services;

import com.leti.server.entities.City;
import com.leti.server.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City getByName(String name){
        return cityRepository.findCityByName(name);
    }

    public void remove(City city) {
        cityRepository.delete(city);
    }

    public void removeAll() {
        cityRepository.deleteAll();
    }
}
