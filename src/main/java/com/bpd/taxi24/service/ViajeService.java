package com.bpd.taxi24.service;

import com.bpd.taxi24.domain.Viaje;
import com.bpd.taxi24.dto.ViajeDTO;

import java.util.List;
import java.util.Optional;

public interface ViajeService {
    List<Viaje> findAll();
    Optional<Viaje> findById(Long id);
    Viaje save(Viaje viaje);
    Viaje update(Viaje viaje);
    void deleteById(Long id);
    List<Viaje> getViajeActivos(String estatus);
    void completandoViaje(Long id, ViajeDTO viajeDTO);
}
