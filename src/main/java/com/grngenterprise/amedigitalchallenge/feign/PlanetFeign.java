package com.grngenterprise.amedigitalchallenge.feign;

import com.grngenterprise.amedigitalchallenge.models.PlanetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "https://swapi.dev/api/planets/?search=", name = "sw")
@FeignClient(url = "https://swapi.dev/api/planets/", name = "sw")
public interface PlanetFeign {

    @GetMapping("{name}")
    PlanetResponse searchPlanetsDetail(@PathVariable("name") String name);

}
