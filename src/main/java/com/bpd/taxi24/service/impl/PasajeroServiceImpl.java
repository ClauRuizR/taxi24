package com.bpd.taxi24.service.impl;

import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.repository.PasajeroRepository;
import com.bpd.taxi24.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServiceImpl implements PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;


    @Override
    public List<Pasajero> findAll() {
        return (List<Pasajero>) pasajeroRepository.findAll();
    }

    @Override
    public Optional<Pasajero> findById(Long id) {
        return pasajeroRepository.findById(id);
    }

    @Override
    public Pasajero save(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    @Override
    public Pasajero update(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    @Override
    public void deleteById(Long id) {
        pasajeroRepository.deleteById(id);
    }
}
