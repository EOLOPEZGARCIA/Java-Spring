package com;

public interface Varias {

    Ticket depositar(String numTarjeta, double monto);
    Ticket pagarServicio(String referencia);
    Ticket transferir(String numTarjeta, String numCuentaDeposito, double monto);



    
}