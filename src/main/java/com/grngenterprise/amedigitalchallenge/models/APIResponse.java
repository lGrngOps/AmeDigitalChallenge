package com.grngenterprise.amedigitalchallenge.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

    private List<PlanetResponse> results;

    public static APIResponse createEmptyResult() {
        var response = new APIResponse();
        response.setResults(Collections.emptyList());
        return response;
    }
}
