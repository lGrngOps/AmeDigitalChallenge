package com.grngenterprise.amedigitalchallenge.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

    private List<PlanetResponse> results;

}

