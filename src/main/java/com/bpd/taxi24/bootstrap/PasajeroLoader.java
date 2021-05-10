package com.bpd.taxi24.bootstrap;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.domain.Viaje;
import com.bpd.taxi24.repository.ConductorRepository;
import com.bpd.taxi24.repository.PasajeroRepository;
import com.bpd.taxi24.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PasajeroLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private ViajeRepository viajeRepository;




    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Pasajero pasajero = new Pasajero();
        pasajero.setNombre("Claudio David Ruiz Rosario");
        pasajeroRepository.save(pasajero);

        Pasajero pasajero2 = new Pasajero();
        pasajero2.setNombre("Elianny Zabala Genao");
        pasajeroRepository.save(pasajero2);

        Conductor conductor = new Conductor();
        conductor.setNombre("Julian Rosario");
        conductor.setLatitude(19.232131);
        conductor.setLongitude(-13.23232);
        conductorRepository.save(conductor);

        Conductor conductor2 = new Conductor();
        conductor2.setNombre("Emma Ruiz");
        conductor2.setLatitude(19.232131);
        conductor2.setLongitude(-13.23232);
        conductorRepository.save(conductor2);

        Conductor conductor3 = new Conductor();
        conductor3.setNombre("David Ruiz");
        conductor3.setLatitude(19.232131);
        conductor3.setLongitude(-13.23232);
        conductorRepository.save(conductor3);

        Viaje viaje = new Viaje();
        viaje.setPasajero(pasajero);
        viaje.setNombre("test");
        viaje.setConductor(conductor);
        viaje.setFecha(LocalDate.now());
        viaje.setLatitudeBegin(19.232131);
        viaje.setLongitudeBegind(-13.23232);
        viaje.setLatitudeEnd(19.832131);
        viaje.setLongitudeEnd(-17.23232);
        viajeRepository.save(viaje);



    }
}
