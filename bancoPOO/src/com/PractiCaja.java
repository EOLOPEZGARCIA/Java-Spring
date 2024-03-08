package com;

import java.util.Date;
import java.util.Scanner;


public class PractiCaja extends Cajero implements Varias {

    

    @Override
    public void generarFolio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarFolio'");
    }

    @Override
    public void generarReporteMovimientos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarReporteMovimientos'");
    }
    

    public Object[] retirar(String numeroTarjeta,String nip,double monto){

        Object[] datos = this.buscar(numeroTarjeta);
        Object[] salida = new Object[2];
        Ticket ticket =null;
        if(datos[0] == null){
            System.out.println("La cuenta no existe!");
            
        }else{
            Cuenta aux = (Cuenta) datos[0];
            if(!(aux.getTarjeta().getNip().equals(nip)))  {
                System.out.println("Nip incorrecto");
            }else if(aux.getSaldo()>monto){
                System.out.println("Saldo insuficiente!");
            }else if(aux.getSaldo()-monto< Cuenta.getSaldoMin()){
                System.out.println("El monto restante seria menor al saldo minimo requerido por la cuenta!");
            }else{
                aux.setSaldo(aux.getSaldo()-monto);
                this.getCuentas().set((int)datos[1], aux);
                ticket = new Ticket(this.getDireccion(),this.getFolio()+1,new Date(),"Retiro",monto);

                salida[0]=ticket;
                salida[1]=monto;
            }
        }
        return salida;
    }

    public Object[] buscar(String numTarjeta){
        Object[] datos = new Object[2];
        for(Cuenta cuenta:this.getCuentas()){
            if(this.getCuentas().get(this.getCuentas().indexOf(cuenta)).getTarjeta().getNumeroTarjeta().equals(numTarjeta)){
                datos[0]= this.getCuentas().get(this.getCuentas().indexOf(cuenta));
                datos[1]=this.getCuentas().indexOf(cuenta);
            }
        }
        return datos;
    }

    public Object[] buscarCu(String numCuenta){
        Object[] datos = new Object[2];
        for(Cuenta cuenta:this.getCuentas()){
            if(this.getCuentas().get(this.getCuentas().indexOf(cuenta)).getNumeroCuenta().equals(numCuenta)){
                datos[0]= this.getCuentas().get(this.getCuentas().indexOf(cuenta));
                datos[1]=this.getCuentas().indexOf(cuenta);
            }
        }
        return datos;
    }


    @Override
    public Ticket depositar(String numTarjeta, double monto) {
        Object[] datos = this.buscar(numTarjeta);
        Ticket ticket =null;
        if(datos[0] == null){
            System.out.println("La cuenta no existe!");
            
        }else{
            Cuenta aux = (Cuenta) datos[0];
            if(Cuenta.getSaldoMax()<monto){
                System.out.println("El monto excede el maximo permitido de la cuenta!");
            }else if(aux.getSaldo()+monto > Cuenta.getSaldoMax()){
                System.out.println("El monto resultante excede al monto maximo de la cuenta!");
            }else{
                aux.setSaldo(aux.getSaldo()+monto);
                this.getCuentas().set((int)datos[1], aux);
                ticket = new Ticket(this.getDireccion(),this.getFolio()+1,new Date(),"Retiro desde: " ,monto);

                
            }
        }

        return ticket;
    
    }

    @Override
    public Ticket pagarServicio(String referencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagarServicio'");
    }

    @Override
    public Ticket transferir(String numTarjeta, String numCuentaDeposito, double monto) {
         Scanner sc = new Scanner(System.in);
        Object[] datos = this.buscar(numTarjeta);
        Object[] datos2 = this.buscarCu(numCuentaDeposito);
        Cuenta aux = (Cuenta) datos[0];
        Cuenta aux2 = (Cuenta) datos2[0];
        
        Ticket ticket =null;
        if(datos[0] == null){
            System.out.println("La cuenta origen no existe!");
            
        }else if(datos2[0] == null){
            System.out.println("La cuenta destino no existe!");
            
        }else{
            System.out.println("Ingrese el nip actual");
                String nip = sc.nextLine();
            if(!(aux.getTarjeta().getNip().equals(nip)))  {
                System.out.println("Nip incorrecto");
            }else if(aux.getSaldo()>monto){
                System.out.println("Saldo insuficiente!");
            }else if(aux.getSaldo()-monto< Cuenta.getSaldoMin()){
                System.out.println("El monto restante seria menor al saldo minimo requerido por la cuenta!");
            }else if(Cuenta.getSaldoMax()<monto){
                System.out.println("El monto excede el maximo permitido de la cuenta!");
            }else if(aux2.getSaldo()+monto > Cuenta.getSaldoMax()){
                System.out.println("El monto resultante excede al monto maximo de la cuenta!");
            }else{
                aux.setSaldo(aux.getSaldo()-monto);
                this.getCuentas().set((int)datos[1], aux);
                aux2.setSaldo(aux2.getSaldo()+monto);
                this.getCuentas().set((int)datos2[1], aux2);
                ticket = new Ticket(this.getDireccion(),this.getFolio()+1,new Date(),"Tranferencia de: "+ aux.getNumeroCuenta() +" hacia: "+ aux2.getNumeroCuenta(),monto);
            }
        }

        return ticket;
    }
        
    


}