package com.bpd.taxi24.controller;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.dto.ConductorDTO;
import com.bpd.taxi24.service.ConductorService;
import com.bpd.taxi24.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Optional<Pasajero> findById(@PathVariable("id") Long id) {
        return pasajeroService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Pasajero pasajero) {
      return pasajeroService.save(pasajero).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Pasajero resource) {

       pasajeroService.findById(resource.getId());
        pasajeroService.update(resource);
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
