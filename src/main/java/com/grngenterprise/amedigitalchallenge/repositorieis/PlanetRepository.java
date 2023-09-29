package com.grngenterprise.amedigitalchallenge.repositorieis;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planets, Long> {

    @Query(value = "select p from Planets p where id like %?1%")
    List<Planets> searchId(Long id);

    @Query(value = "select p from Planets p where nome like %?1%")
    List<Planets> searchNome(String nome);

}
