package com.bpd.taxi24.repository;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Viaje;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ViajeRepository extends CrudRepository<Viaje,Long> {
    List<Viaje> findViajeByEstatus(String estatus);
}
