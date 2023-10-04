package com.grngenterprise.amedigitalchallenge.controllers;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.models.PlanetDTO;
import com.grngenterprise.amedigitalchallenge.models.PlanetRequest;
import com.grngenterprise.amedigitalchallenge.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping(value = "/")

public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping("/api/{plan}")
    public PlanetRequest consultAPI (@PathVariable("plan") String plan){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlanetRequest> response = restTemplate.getForEntity(String.format("https://swapi.dev/api/planets/%s", plan), PlanetRequest.class);
        return planetService.consultAPI(response.getBody());
        //return response.getBody();
    }

    @PostMapping(value = "/create")
    public PlanetDTO createPlanets (@RequestBody PlanetDTO planetDTO){ return planetService.createPlanet(planetDTO);     }

    @GetMapping(value = "/planets")
    public List<Planets> findAllPlanets(){
        return planetService.findAllPlanets();
    }

    @GetMapping(value = "/delete/{id}")
    public void deletePlanets(@PathVariable("id") Long id){ planetService.deletePlanets(id);    }

    @GetMapping(value = "/planets/{name}")
    public List<Planets> searchNome (@PathVariable("name")String name){
        return planetService.searchName(name);
    }

    @GetMapping(value = "/planets/{id}")
    public List<Planets> searchId (@PathVariable("id")Long id){
        return planetService.searchId(id);
    }

}
