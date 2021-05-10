package com.bpd.taxi24.domain;

import com.bpd.taxi24.enums.Estatus;

import javax.persistence.*;

@Entity
@Table(name="viaje")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private Integer estado = 1;

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
}
