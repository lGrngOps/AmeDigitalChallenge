package com.grngenterprise.amedigitalchallenge.feign;

import com.grngenterprise.amedigitalchallenge.models.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        url = "https://swapi.dev/api/planets",
        name = "swapi")

public interface PlanetFeign {

    @GetMapping
    APIResponse findAll();

    @GetMapping("/?search={planet}")
    APIResponse findPlanetByName(@RequestParam(name = "planet")String planet);

}
