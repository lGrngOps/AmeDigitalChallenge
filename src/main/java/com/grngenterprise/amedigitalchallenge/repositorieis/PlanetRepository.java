package com.grngenterprise.amedigitalchallenge.repositorieis;

import com.grngenterprise.amedigitalchallenge.entities.Planets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planets, Long> {

}
