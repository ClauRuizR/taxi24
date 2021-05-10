package com.bpd.taxi24.service.impl;

import com.bpd.taxi24.domain.Viaje;
import com.bpd.taxi24.dto.ViajeDTO;
import com.bpd.taxi24.enums.Estatus;
import com.bpd.taxi24.repository.ViajeRepository;
import com.bpd.taxi24.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeServiceImpl implements ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public List<Viaje> findAll() {
        return (List<Viaje>) viajeRepository.findAll();
    }

    @Override
    public Optional<Viaje> findById(Long id) {
        return viajeRepository.findById(id);
    }

    @Override
    public Viaje save(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public Viaje update(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public void deleteById(Long id) {
        viajeRepository.deleteById(id);
    }

    @Override
    public List<Viaje> getViajeActivos(String estatus) {
        return viajeRepository.findViajeByEstatus(Estatus.PENDIENTE.getCode());
    }

    @Override
    public void completandoViaje(Long id, ViajeDTO viajeDTO) {
        Viaje viaje = viajeRepository.findById(id).get();
        viaje.setEstatus(viajeDTO.getEstatus());
        viajeRepository.save(viaje);
    }
}
