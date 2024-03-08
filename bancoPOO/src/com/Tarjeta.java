package com;

public class Tarjeta {
    private String numeroTarjeta;
    private String cvv;
    private String vencimiento;
    private String nip;

    public Tarjeta(){

    }

    public Tarjeta(String numeroTarjeta, String cvv, String vencimiento, String nip) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.vencimiento = vencimiento;
        this.nip = nip;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Tarjeta [numeroTarjeta=" + numeroTarjeta + ", cvv=" + cvv + ", vencimiento=" + vencimiento + ", nip="
                + nip + "]";
    }

    
    
}