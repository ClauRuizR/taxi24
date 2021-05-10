package com.bpd.taxi24.controller;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.domain.Viaje;
import com.bpd.taxi24.dto.ViajeDTO;
import com.bpd.taxi24.enums.Estatus;
import com.bpd.taxi24.service.ConductorService;
import com.bpd.taxi24.service.PasajeroService;
import com.bpd.taxi24.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viaje")
public class ViajeController {
    @Autowired
    private ViajeService viajeService;

    @GetMapping
    public List<Viaje> findAll() {
        return viajeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Viaje> findById(@PathVariable("id") Long id) {

        Viaje viaje =  viajeService.findById(id).orElse(null);

        if(viaje== null){
            return  new ResponseEntity<>(viaje, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(viaje , HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Viaje viaje) {
        return viajeService.save(viaje).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Viaje resource) {

        Viaje viaje = viajeService.findById(resource.getId()).orElse(null);

        if(viaje!=null)
        viajeService.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        viajeService.deleteById(id);
    }

    @PatchMapping(value = "/completado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void completeViaje(@PathVariable( "id" ) Long id, @RequestBody ViajeDTO viajeDTO) {
        viajeService.completandoViaje(id,viajeDTO);
    }


}
