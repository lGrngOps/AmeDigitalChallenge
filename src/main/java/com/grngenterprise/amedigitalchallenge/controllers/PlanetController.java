package com.grngenterprise.amedigitalchallenge.controllers;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import com.grngenterprise.amedigitalchallenge.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")

public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @PostMapping(value = "/create")
    public Planets createPlanets (@RequestBody Planets planets){
        return planetService.createPlanet(planets);
    }

    @GetMapping(value = "/planets")
    public List<Planets> findAllPlanets(){
        return planetService.findAllPlanets();
    }

    @GetMapping(value = "/delete/{id}")
    public void deletePlanets(@PathVariable("id") Long id){
        planetService.deletePlanets(id);
    }

    @GetMapping(value = "/find/{nome}")
    public List<Planets> searchNome (@PathVariable("nome")String nome){
        return planetService.searchNome(nome);
    }

    @GetMapping(value = "/search/{id}")
    public List<Planets> searchId (@PathVariable("id")Long id){
        return planetService.searchId(id);
    }

}
