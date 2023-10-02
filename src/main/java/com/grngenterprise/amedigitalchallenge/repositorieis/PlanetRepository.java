package com.grngenterprise.amedigitalchallenge.repositorieis;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planets, Long> {

    @Query(value = "select p from Planets p where p.id = :id")
    List<Planets> searchId(Long id);

    @Query(value = "select p from Planets p where name like %?1%")
    List<Planets> searchName(String name);

}
