package com.bpd.taxi24.repository;

import com.bpd.taxi24.domain.Conductor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConductorRepository extends CrudRepository<Conductor,Long> {
   // List<Conductor> findByLatitudeBetweenAndLongitude(double latitude, double longitude);

}
