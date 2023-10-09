package com.grngenterprise.amedigitalchallenge.services;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.feign.PlanetFeign;
import com.grngenterprise.amedigitalchallenge.models.APIResponse;
import com.grngenterprise.amedigitalchallenge.models.PlanetResponse;
import com.grngenterprise.amedigitalchallenge.repositorieis.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private PlanetFeign planetFeign;

    public APIResponse findAll() {
        try {
            return planetFeign
                    .findAll()
                    .orElse(APIResponse.createEmptyResult());
        } catch (Exception ex) {
            ex.printStackTrace();
            return APIResponse.createEmptyResult();
        }
    }

    public APIResponse findPlanetByName(String planet){
        try{
            return planetFeign
                    .findPlanetByName(planet)
                    .orElse(APIResponse.createEmptyResult());
        } catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.createEmptyResult();
        }
    }

    public PlanetResponse createPlanet(PlanetResponse planetResponse){

        Planets planets = new Planets();

        planets.setName(planetResponse.getName());
        planets.setClimate(planetResponse.getClimate());
        planets.setTerrain(planetResponse.getTerrain());

        //PlanetRequest planetRequest = new PlanetRequest();
        //planets.setAppears(planetRequest.getAp());
        //planetResponse.setAppears(planetRequest.getAp());

        planetRepository.save(planets);
        return planetResponse;
    }

    //public PlanetRequest consultAPI(PlanetRequest planetRequest){
    //    planetRequest.setAp(planetRequest.getFilms().size());
    //    planetRequest.setFilms(planetRequest.getFilms());
    //    planetRequest.setName(planetRequest.getName());
    //    return planetRequest;
    //}

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
