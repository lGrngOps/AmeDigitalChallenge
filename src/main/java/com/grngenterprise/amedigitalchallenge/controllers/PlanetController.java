package com.grngenterprise.amedigitalchallenge.controllers;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.feign.PlanetFeign;
import com.grngenterprise.amedigitalchallenge.models.PlanetResponse;
import com.grngenterprise.amedigitalchallenge.models.APIResponse;
import com.grngenterprise.amedigitalchallenge.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/")

public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PlanetFeign planetFeign;

    @GetMapping("/api")
    public APIResponse findAll(){
        return planetService.findAll();
    }

    @GetMapping("api/{planet}")
    public APIResponse findPlanetByName(@PathVariable("planet") String planet){
        return planetService.findPlanetByName(planet);
    }

    @PostMapping(value = "/create")
    public PlanetResponse createPlanets (@RequestBody PlanetResponse planetResponse){
        return planetService.createPlanet(planetResponse);
    }

    @GetMapping(value = "/planets")
    public List<Planets> findAllPlanets(){
        return planetService.findAllPlanets();
    }

    @GetMapping(value = "/delete/{id}")
    public void deletePlanets(@PathVariable("id") Long id){
        planetService.deletePlanets(id);
    }

    @GetMapping(value = "/planets/{name}")
    public List<Planets> searchNome (@PathVariable("name")String name){
        return planetService.searchName(name);
    }

    @GetMapping(value = "/planets/{id}")
    public List<Planets> searchId (@PathVariable("id")Long id){
        return planetService.searchId(id);
    }

    // API Consumida via RestTemplate
    //@GetMapping("/api")
    //public PlanetRequest consultAPI (){
    //    RestTemplate restTemplate = new RestTemplate();
    //    ResponseEntity<PlanetRequest> response = restTemplate.getForEntity(String.format("https://swapi.dev/api/planets?format=json"), PlanetRequest.class);
    //    return planetService.consultAPI(response.getBody());
    //    //return response.getBody();
    //}

}
