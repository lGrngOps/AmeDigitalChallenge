package com.grngenterprise.amedigitalchallenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {

    private String name;
    private String climate;
    private String terrain;
    private Integer appears;

}
