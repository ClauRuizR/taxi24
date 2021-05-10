package com.bpd.taxi24.domain;

import com.bpd.taxi24.enums.Estatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="viaje")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private Integer estado = 1;

    private LocalDate fecha;

    private double latitudeBegin;

    private double longitudeBegind;

    private double latitudeEnd;

    private double longitudeEnd;

    private double distance;

    private String estatus = Estatus.PENDIENTE.getCode();

    @ManyToOne
    @JoinColumn(name="conductor_id")
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name="pasajero_id")
    private Pasajero pasajero;

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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getLatitudeBegin() {
        return latitudeBegin;
    }

    public void setLatitudeBegin(double latitudeBegin) {
        this.latitudeBegin = latitudeBegin;
    }

    public double getLongitudeBegind() {
        return longitudeBegind;
    }

    public void setLongitudeBegind(double longitudeBegind) {
        this.longitudeBegind = longitudeBegind;
    }

    public double getLatitudeEnd() {
        return latitudeEnd;
    }

    public void setLatitudeEnd(double latitudeEnd) {
        this.latitudeEnd = latitudeEnd;
    }

    public double getLongitudeEnd() {
        return longitudeEnd;
    }

    public void setLongitudeEnd(double longitudeEnd) {
        this.longitudeEnd = longitudeEnd;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
