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
@RequestMapping("/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public List<Conductor> findAll() {
        return conductorService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Conductor> findById(@PathVariable("id") Long id) {
        return conductorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Conductor conductor) {
        return conductorService.save(conductor).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Conductor resource) {

        conductorService.findById(resource.getId());
        conductorService.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        conductorService.deleteById(id);
    }


    @GetMapping("/getConductorDisponibles")
    public List<Conductor> getConductorDisponibles(){
        return conductorService.getConductorDisponibles();
    }
    @GetMapping(value="/getAllConductorByDistance/{lat2}/{lon2}")
    public List<ConductorDTO> getAllConductorByDistance(@PathVariable("lat2") double lat2, @PathVariable("lat2") double lon2 ){
        return conductorService.getAllConductorByDistance(lat2,lon2);

    }
}
