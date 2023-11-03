package com.grngenterprise.amedigitalchallenge.services;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.feign.PlanetFeign;
import com.grngenterprise.amedigitalchallenge.models.APIResponse;
import com.grngenterprise.amedigitalchallenge.models.PlanetDTO;
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
            return planetFeign.findAll();
    }

    public APIResponse findPlanetByName(String planet){
            return planetFeign.findPlanetByName(planet);
    }

    public PlanetDTO createPlanet(PlanetDTO planetDTO){

        Planets planets = new Planets();
        planets.setName(planetDTO.getName());
        planets.setClimate(planetDTO.getClimate());
        planets.setTerrain(planetDTO.getTerrain());

        String planetcadastro = planetDTO.getName().toUpperCase();
        APIResponse planetresp = planetFeign.findPlanetByName(planetcadastro);

        if (planetresp.getResults().isEmpty()){
            planets.setAppears(0);
            planetDTO.setAppears(0);
        } else if (!planetcadastro.equals(planetresp.getResults().get(0).getName().toUpperCase())){
            planets.setAppears(0);
            planetDTO.setAppears(0);
        } else {
            planets.setAppears(planetresp.getResults().get(0).getFilms().size());
            planetDTO.setAppears(planets.getAppears());
        }
        planetRepository.save(planets);
        return planetDTO;
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

    // API Consumida via Rest Template
    //public PlanetRequest consultAPI(PlanetRequest planetRequest){
    //    planetRequest.setAp(planetRequest.getFilms().size());
    //    planetRequest.setFilms(planetRequest.getFilms());
    //    planetRequest.setName(planetRequest.getName());
    //    return planetRequest;
    //}
}
