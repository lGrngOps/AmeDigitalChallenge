package com.grngenterprise.amedigitalchallenge.services;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.feign.PlanetFeign;
import com.grngenterprise.amedigitalchallenge.models.PlanetRequest;
import com.grngenterprise.amedigitalchallenge.models.PlanetResponse;
import com.grngenterprise.amedigitalchallenge.repositorieis.PlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    private PlanetFeign planetFeign;

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

    public PlanetResponse consultAPI (PlanetRequest planetRequest){
        return planetFeign.searchPlanetsDetail(planetRequest.getName());
    }
}
