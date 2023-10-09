package com.grngenterprise.amedigitalchallenge.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetResponse {

    private String name;
    private String climate;
    private String terrain;
    private ArrayList films;
    //private Integer appears;

}
