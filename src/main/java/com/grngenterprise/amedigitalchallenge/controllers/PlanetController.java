package com.grngenterprise.amedigitalchallenge.controllers;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.models.APIResponse;
import com.grngenterprise.amedigitalchallenge.models.PlanetDTO;
import com.grngenterprise.amedigitalchallenge.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")

public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping(value = "api")
    public APIResponse findAll(){
        return planetService.findAll();
    }

    @GetMapping("api/{planet}")
    public APIResponse findPlanetByName(@PathVariable("planet") String planet){
        return planetService.findPlanetByName(planet);
    }

    @PostMapping(value = "create")
    public PlanetDTO createPlanets (@RequestBody PlanetDTO planetDTO){
        return planetService.createPlanet(planetDTO);
    }

    @GetMapping(value = "planets")
    public List<Planets> findAllPlanets(){
        return planetService.findAllPlanets();
    }

    @GetMapping(value = "planets/delete/{id}")
    public void deletePlanets(@PathVariable("id") Long id){
        planetService.deletePlanets(id);
    }

    @GetMapping(value = "planets/name/{name}")
    public List<Planets> searchNome (@PathVariable("name")String name){
        return planetService.searchName(name);
    }

    @GetMapping(value = "planets/id/{id}")
    public List<Planets> searchId (@PathVariable("id")Long id){
        return planetService.searchId(id);
    }

    // API Consumida via Rest Template
    //@GetMapping("/api")
    //public PlanetRequest consultAPI (){
    //    RestTemplate restTemplate = new RestTemplate();
    //    ResponseEntity<PlanetRequest> response = restTemplate.getForEntity(String.format("https://swapi.dev/api/planets?format=json"), PlanetRequest.class);
    //    return planetService.consultAPI(response.getBody());
    //    //return response.getBody();
    //}
}
