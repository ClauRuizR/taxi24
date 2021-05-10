package com.bpd.taxi24.enums;

public enum Estatus {
    PENDIENTE("Pendiente", "P"),
    COMPLETADO("Completado","C");

    public final String description;
    public final String code;

    private Estatus(String descripcion, String code) {
        this.description = descripcion;
        this.code = code;
    }

    public String getdescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}