package org.example;

import java.util.Date;
import java.util.UUID;

public abstract class Reserva {
    private Date fechaInicial;
    private Date fechaFinal;
    private Float precio;
    private String descripcion;
    private UUID id;

    public Reserva(Date fechaInicial, Date fechaFinal, Float precio, String descripcion) {
        this.id = UUID.randomUUID();
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Date getFechaFinal() {

        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }
}
