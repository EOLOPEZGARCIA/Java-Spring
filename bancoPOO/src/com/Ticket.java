package com;

import java.util.Date;

public class Ticket {
    private String ubicacion;
    private int folio;
    private Date fecha;
    private String tipoOperacion;
    private double monto;
    private String referencia;

    public Ticket(){

    }
    //constructor para operaciones bancaria
    public Ticket(String ubicacion, int folio, Date fecha, String tipoOperacion, double monto) {
        this.ubicacion = ubicacion;
        this.folio = folio;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    //constructor para pago de servicios referenciados
    

    public String getUbicacion() {
        return ubicacion;
    }

    public Ticket(String ubicacion, int folio, Date fecha, String tipoOperacion, double monto, String referencia) {
        this.ubicacion = ubicacion;
        this.folio = folio;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.referencia = referencia;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Ticket [ubicacion=" + ubicacion + ", folio=" + folio + ", fecha=" + fecha + ", tipoOperacion="
                + tipoOperacion + ", monto=" + monto + "]";
    }

    

    
}