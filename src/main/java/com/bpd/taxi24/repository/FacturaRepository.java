package com.bpd.taxi24.repository;

import com.bpd.taxi24.domain.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura,Long> {
    Factura findByPasajeroId(Long id);
}
