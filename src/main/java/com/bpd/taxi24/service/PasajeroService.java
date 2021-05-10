package com.bpd.taxi24.service;

import com.bpd.taxi24.domain.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {
    List<Pasajero> findAll();
    Optional<Pasajero> findById(Long id);
    Pasajero save(Pasajero pasajero);
    Pasajero update(Pasajero pasajero);
    void deleteById(Long id);
}
