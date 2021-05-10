package com.bpd.taxi24.bootstrap;

import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PasajeroLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PasajeroRepository pasajeroRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Pasajero pasajero = new Pasajero();
        pasajero.setNombre("Claudio David Ruiz Rosario");
        pasajeroRepository.save(pasajero);
    }
}
