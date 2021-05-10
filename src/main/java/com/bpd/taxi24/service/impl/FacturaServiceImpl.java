package com.bpd.taxi24.service.impl;

import com.bpd.taxi24.domain.DetalleFactura;
import com.bpd.taxi24.domain.Factura;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.domain.Viaje;
import com.bpd.taxi24.repository.ConductorRepository;
import com.bpd.taxi24.repository.FacturaRepository;
import com.bpd.taxi24.repository.PasajeroRepository;
import com.bpd.taxi24.repository.ViajeRepository;
import com.bpd.taxi24.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private PasajeroRepository pasajeroRepository;


    @Override
    public Factura crearFactura(Long conductorId, Long viajeId, Long pasajeroId) {

        Viaje viaje = viajeRepository.findById(viajeId).orElse(null);

        Factura factura = new Factura();
        factura.setConductor(conductorRepository.findById(conductorId).orElse(null));
        factura.setPasajero(pasajeroRepository.findById(pasajeroId).orElse(null));
        factura.setMonto(new BigDecimal(viaje.getDistance() * 0.15));
        factura.setFecha(new Date());
        DetalleFactura detalleFactura = new DetalleFactura();



        detalleFactura.setViaje(viaje);
        detalleFactura.setMonto(new BigDecimal(viaje.getDistance() * 0.15));

        List<DetalleFactura> detalleFacturaList = new ArrayList<>();
        detalleFacturaList.add(detalleFactura);
        factura.setDetalleFactura(detalleFacturaList);
        return facturaRepository.save(factura);
    }

    @Override
    public Factura findByPasajeroId(Long id) {
        return facturaRepository.findByPasajeroId(id);
    }
}
