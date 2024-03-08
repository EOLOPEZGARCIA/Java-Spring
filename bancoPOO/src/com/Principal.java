package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        List<Cuenta> cuentas = new ArrayList<Cuenta>();

        Tarjeta tarCue = new Tarjeta("456112307894","856","06/28","4561");

        Cuenta cue = new Cuenta("789456123", "700100789456123", "8507156", 500, "ahorro", tarCue);

        cuentas.add(cue);
        Scanner sc = new Scanner(System.in) ;
            int opcion = 0;
       


    }
    
}