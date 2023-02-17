package com.cristobalbernal.Actividad2Alberto.Utilidades;

public class Sumador {
    public static int suma(String cadenaTexto){
        int suma = 0;
        for (int i = 0; i < cadenaTexto.length(); i++) {
            suma += cadenaTexto.codePointAt(i);
        }
        return suma;
    }
}
