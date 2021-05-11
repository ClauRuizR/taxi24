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
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

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
        conductor.setLatitude(18.48022);
        conductor.setLongitude(-69.86313);
        conductorRepository.save(conductor);

        Conductor conductor2 = new Conductor();
        conductor2.setNombre("Emma Ruiz");
        conductor2.setLatitude(18.48013);
        conductor2.setLongitude(-69.86403);
        conductorRepository.save(conductor2);

        Conductor conductor3 = new Conductor();
        conductor3.setNombre("David Ruiz");
        conductor3.setLatitude(18.45146);
        conductor3.setLongitude(-69.93886);
        conductorRepository.save(conductor3);


        Conductor conductor4 = new Conductor();
        conductor4.setNombre("Sebastian Mota");
        conductor4.setLatitude(18.47513);
        conductor4.setLongitude(-69.88824);
        conductorRepository.save(conductor3);

        Viaje viaje = new Viaje();
        viaje.setPasajero(pasajero);
        viaje.setNombre("test");
        viaje.setConductor(conductor);
        viaje.setFecha(LocalDate.now());
        viaje.setLatitudeBegin(18.48022);
        viaje.setLongitudeBegind(-69.86313);
        viaje.setLatitudeEnd(18.47101);
        viaje.setLongitudeEnd(-69.88534);
        viajeRepository.save(viaje);



    }



}
