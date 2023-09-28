package com.grngenterprise.amedigitalchallenge.controllers;

import com.grngenterprise.amedigitalchallenge.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")

public class PlanetController {

    @Autowired
    private PlanetService planetService;

}
