package com.grngenterprise.amedigitalchallenge.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {

    @NotEmpty(message = "Favor inserir um nome :")
    private String name;
    @NotEmpty(message = "Favor inserir o clima :")
    private String climate;
    @NotEmpty(message = "Favor inserir o terreno :")
    private String terrain;
    private Integer appears;

}
