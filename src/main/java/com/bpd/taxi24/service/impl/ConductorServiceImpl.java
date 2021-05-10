package com.bpd.taxi24.service.impl;

import com.bpd.taxi24.domain.Conductor;
import com.bpd.taxi24.domain.Pasajero;
import com.bpd.taxi24.dto.ConductorDTO;
import com.bpd.taxi24.repository.ConductorRepository;
import com.bpd.taxi24.repository.ViajeRepository;
import com.bpd.taxi24.service.ConductorService;
import com.bpd.taxi24.utils.UtilsCalculator;
import com.bpd.taxi24.utils.UtilsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public List<Conductor> findAll() {
        return (List<Conductor>) conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> findById(Long id) {
        return conductorRepository.findById(id);
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor update(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public void deleteById(Long id) {
        conductorRepository.deleteById(id);

    }

    @Override
    public List<Conductor> findByLatitudeBetweenAndLongitude(double latitude, double longtitude) {
      //  return conductorRepository.findByLatitudeBetweenAndLongitude(latitude,longtitude);
        return (List<Conductor>) conductorRepository.findAll();
    }

    @Override
    public List<Conductor> getConductorDisponibles() {
        List<Conductor> conductorList = entityManager.createNamedQuery("Conductor.findAllConductorDisponible", Conductor.class).getResultList();

        return conductorList;
    }

    @Override
    public List<ConductorDTO> getAllConductorByDistance(double lat2, double lon2) {

        List<ConductorDTO> conductorDTOList = new ArrayList<>();
        List<Conductor> conductorList = (List<Conductor>) conductorRepository.findAll();
        for(Conductor conductor : conductorList){
            if(conductor.getEstado() == 0)
                continue;

            double distance = UtilsCalculator.distanceCalculator(conductor.getLatitude(), conductor.getLongitude(), lat2,lon2, "K");

            if(distance >= 3){
                ConductorDTO conductorDTO = new ConductorDTO();
                conductorDTO.setId(conductor.getId());
                conductorDTO.setLatitude(conductor.getLatitude());
                conductorDTO.setLongitude(conductor.getLongitude());

                conductorDTOList.add(conductorDTO);
            }
        }
        return conductorDTOList ;
    }

    @Override
    public List<ConductorDTO> findConductoresCercanos(double lat2, double lon2) {
        List<ConductorDTO> conductorDTOList = new ArrayList<>();
        List<Conductor> conductorList = (List<Conductor>) conductorRepository.findAll();

        for(Conductor conductor : conductorList){
            if(conductor.getEstado() == 0)
                continue;

            double distance = UtilsCalculator.distanceCalculator(conductor.getLatitude(), conductor.getLongitude(), lat2,lon2, "K");

            if(distance <= 3){
                ConductorDTO conductorDTO = new ConductorDTO();
                conductorDTO.setId(conductor.getId());
                conductorDTO.setLatitude(conductor.getLatitude());
                conductorDTO.setLongitude(conductor.getLongitude());

                conductorDTOList.add(conductorDTO);

                if(conductorDTOList.size() == 3)
                break;
            }
        }
        return conductorDTOList ;
    }


}
