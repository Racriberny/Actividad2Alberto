package com.cristobalbernal.Actividad2Alberto.Utilidades;

public class Sumador {
    public static int sumar(String cadenaTexto){
        int suma = 0;
        for (int i = 0; i < cadenaTexto.length(); i++) {
            suma += cadenaTexto.codePointAt(i);
        }
        return suma;
    }
}
