package com.bpd.taxi24.domain;

import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "Conductor.findAllConductorDisponible",
        query="select * from conductor c where not exists(select 1 from viaje v where v.conductor_id = c.id and v.estatus = 'P');"
,
        resultClass = Conductor.class)
@Table(name="conductor")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private double latitude;

    private double longitude;

    private Integer estado = 1;

    @Version
    private Long version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
