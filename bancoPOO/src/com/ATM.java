package com;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ATM extends Cajero{

    private String numSerie;

    public ATM(){

    }

    
    

    public ATM(String direccion, int folio, List<Cuenta> cuentas, Map<String, List<Cuenta>> mapaDeStatus,
            String numSerie) {
        super(direccion, folio, cuentas, mapaDeStatus);
        this.numSerie = numSerie;
    }




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




    public String getNumSerie() {
        return numSerie;
    }




    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

}