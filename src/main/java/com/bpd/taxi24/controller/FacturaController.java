package com.bpd.taxi24.controller;

import com.bpd.taxi24.domain.Factura;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping(value = "/obtenerFacturaPorPasajero/{id}")
    public ResponseEntity<Factura> findById(@PathVariable("id") Long id) {

        Factura factura =  facturaService.findByPasajeroId(id);

        if(factura== null){
            return  new ResponseEntity<>(factura, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(factura , HttpStatus.OK);

    }
}
