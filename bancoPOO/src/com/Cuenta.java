package com;

public class Cuenta {

    private String numeroCuenta;
    private String clabe;
    private String cliente;
    private double saldo;
    private String tipoCuenta;
    private static final double SALDO_MAX = 150000;
    private static final double SALDO_MIN = 2000;

    private Tarjeta tarjeta; // Composicion

    public Cuenta(){

    }

    public Cuenta(String numeroCuenta, String clabe, String cliente, double saldo, String tipoCuenta, Tarjeta tarjeta) {
        this.numeroCuenta = numeroCuenta;
        this.clabe = clabe;
        this.cliente = cliente;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.tarjeta = tarjeta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public static double getSaldoMax() {
        return SALDO_MAX;
    }

    public static double getSaldoMin() {
        return SALDO_MIN;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", clabe=" + clabe + ", cliente=" + cliente + ", saldo=" + saldo
                + ", tipoCuenta=" + tipoCuenta + ", tarjeta=" + tarjeta + "]";
    }

    
    


}