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
@RequestMapping("/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;


    @GetMapping
    public List<Conductor> findAll() {
        return conductorService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conductor> findById(@PathVariable("id") Long id) {

        Conductor conductor =  conductorService.findById(id).orElse(null);

        if(conductor== null){
            return  new ResponseEntity<>(conductor, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(conductor , HttpStatus.OK);


    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conductor create(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conductor update(@PathVariable( "id" ) Long id, @RequestBody Conductor resource) {

        Conductor conductor=   conductorService.findById(resource.getId()).orElse(null);

        return  conductorService.update(conductor);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        conductorService.deleteById(id);
    }


    @GetMapping("/conductoresDisponibles")
    public List<Conductor> getConductoresDisponibles(){
        return conductorService.getConductorDisponibles();
    }

    @GetMapping(value="/conductoresPorDistancia/{lat2}/{lon2}")
    public List<ConductorDTO> getAllConductorByDistance(@PathVariable("lat2") double lat2, @PathVariable("lat2") double lon2 ){
        return conductorService.getAllConductorByDistance(lat2,lon2);

    }
}
