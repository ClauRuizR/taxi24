package com.bpd.taxi24.service;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.dto.ConductorDTO;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    List<Conductor> findAll();
    Optional<Conductor> findById(Long id);
    Conductor save(Conductor conductor);
    Conductor update(Conductor conductor);
    void deleteById(Long id);
    List<Conductor> findByLatitudeBetweenAndLongitude(double latitude, double longtitude);
    List<Conductor> getConductorDisponibles();
    List<ConductorDTO> getAllConductorByDistance(double lat2, double lon2);
    List<ConductorDTO> findConductoresCercanos(double lat2, double lon2);
}
