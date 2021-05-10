package com.bpd.taxi24.controller;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.dto.ConductorDTO;
import com.bpd.taxi24.service.ConductorService;
import com.bpd.taxi24.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pasajero")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public List<Pasajero> findAll() {
        return pasajeroService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pasajero> findById(@PathVariable("id") Long id) {

        Pasajero pasajero =  pasajeroService.findById(id).orElse(null);

        if(pasajero== null){
            return  new ResponseEntity<>(pasajero, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pasajero , HttpStatus.OK);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pasajero create(@RequestBody Pasajero pasajero) {
      return pasajeroService.save(pasajero);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pasajero update(@PathVariable( "id" ) Long id, @RequestBody Pasajero resource) {

       pasajeroService.findById(resource.getId());
      return  pasajeroService.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        pasajeroService.deleteById(id);
    }

    @GetMapping(value="/obtenerViaje/{latitude}/{longitude}")
    public List<ConductorDTO> conductorList(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude){

       return conductorService.findConductoresCercanos(latitude,longitude);
    }
}
