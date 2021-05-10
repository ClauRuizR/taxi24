package com.bpd.taxi24.service;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Factura;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.domain.Viaje;

public interface FacturaService {
    Factura crearFactura(Long conductorId, Long viajeId, Long pasajeroId);
    Factura findByPasajeroId(Long id);
}
