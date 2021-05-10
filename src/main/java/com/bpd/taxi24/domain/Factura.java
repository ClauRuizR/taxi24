package com.bpd.taxi24.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha ;

    private String estatus = "P";

    private Integer estado = 1;

    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name="pasajero_id")
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name="conductor_id")
    private Conductor conductor;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleFactura> DetalleFactura = new ArrayList<>();

    @Version
    private Long version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }


    public List<com.bpd.taxi24.domain.DetalleFactura> getDetalleFactura() {
        return DetalleFactura;
    }

    public void setDetalleFactura(List<com.bpd.taxi24.domain.DetalleFactura> detalleFactura) {
        DetalleFactura = detalleFactura;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
