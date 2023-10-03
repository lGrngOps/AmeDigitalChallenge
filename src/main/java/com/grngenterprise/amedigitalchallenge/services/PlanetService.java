package com.grngenterprise.amedigitalchallenge.services;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.repositorieis.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public Planets createPlanet(Planets planets){
        return this.planetRepository.save(planets);
    }

    public List<Planets> findAllPlanets(){
        List<Planets> list = planetRepository.findAll();
        return list;
    }

    public List<Planets> searchId (Long id){
        List<Planets> list = planetRepository.searchId(id);
        return list;
    }

    public List<Planets> searchName (String name){
        List<Planets> list = planetRepository.searchName(name);
        return list;
    }

    public void deletePlanets(Long id){
        if (planetRepository.existsById(id)){
            planetRepository.deleteById(id);
        }
        else
            throw new IllegalArgumentException("Planeta não localizado");
    }
}
