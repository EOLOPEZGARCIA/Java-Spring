package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Cajero {

    private String direccion;
    private int folio = 0;

    // Lista de cuentas(BD)

    private List<Cuenta> cuentas = new ArrayList<Cuenta>(); // Se esta usando composicion

    // cuentas bloqueadas y no bloqeadas con un mapa
    private Map<String, List<Cuenta>> mapaDeStatus = new HashMap<String, List<Cuenta>>();

    public Cajero() {

    }

    public Cajero(String direccion, int folio, List<Cuenta> cuentas, Map<String, List<Cuenta>> mapaDeStatus) {
        this.direccion = direccion;
        this.folio = folio;
        this.cuentas = cuentas;
        this.mapaDeStatus = mapaDeStatus;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Map<String, List<Cuenta>> getMapaDeStatus() {
        return mapaDeStatus;
    }

    public void setMapaDeStatus(Map<String, List<Cuenta>> mapaDeStatus) {
        this.mapaDeStatus = mapaDeStatus;
    }

    @Override
    public String toString() {
        return "Cajero [direccion=" + direccion + ", folio=" + folio + ", cuentas=" + cuentas + ", mapaDeStatus="
                + mapaDeStatus + "]";
    }

    public void cambiarNip(String numTarjeta) {
        Scanner sc = new Scanner(System.in);

        // Buscar la tarjeta dentro de las cuentas
        // por cada cuenta que encuentres dentro de la lista...
        for (Cuenta cuentaActual : cuentas) {

            if (cuentas.get(cuentas.indexOf(cuentaActual)).getTarjeta().getNumeroTarjeta().equals(numTarjeta)) {
                // cambia el nip de la tarjeta

                System.out.println("Ingrese el nip actual");
                String nipActual = sc.nextLine();

                if (cuentas.get(cuentas.indexOf(cuentaActual)).getTarjeta().getNip().equals(nipActual)) {

                    System.out.println("Ingrese nuevo nip");
                    String nip = sc.nextLine();
                    cuentas.get(cuentas.indexOf(cuentaActual)).getTarjeta().setNip(nip);
                    System.out.println("Nip cambiado con exito");
                } else {
                    System.out.println("NIp incorrecto");
                }
            } else {
                System.out.println("No existe la tarjeta");
            }
        }
    }

    public abstract void generarFolio();

    public abstract void generarReporteMovimientos();




}