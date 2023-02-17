package com.cristobalbernal.Actividad2Alberto.Cliente;

import com.cristobalbernal.Actividad2Alberto.Utilidades.Lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public void verificarCadenas(BufferedReader bfr, PrintWriter pw) throws IOException {
        pw.println(3);
        System.out.println("Escribe la primera palabra: ");
        String palabraUno = Lib.leerLinea();
        System.out.println("Escribe la segunda palabra: ");
        String palabraDos = Lib.leerLinea();
        System.out.println("Escribee la tercera palabra: ");
        String palabraTres = Lib.leerLinea();
        pw.println(palabraUno);
        pw.println(palabraDos);
        pw.println(palabraTres);
        pw.println();
        pw.flush();
        String suma1 = bfr.readLine();
        String suma2 = bfr.readLine();
        String suma3 = bfr.readLine();
        System.out.println(suma1);
        System.out.println(suma2);
        System.out.println(suma3);
    }

    public static void main(String[] args) {
        Cliente cliente;
        cliente = new Cliente();
        InetSocketAddress direccion;
        direccion = new InetSocketAddress("192.168.20.68", 9876);
        Socket conexion;
        conexion = new Socket();
        try {
            conexion.connect(direccion);
            BufferedReader bfr;
            bfr = Lib.getFlujoLectura(conexion);
            PrintWriter pw;
            pw = Lib.getFlujoEscritura(conexion);
            cliente.verificarCadenas(bfr, pw);
            pw.close();
            bfr.close();
            conexion.close();
        } catch (IOException e) {
            //Quiza el servidor no está encendido
            //Quizá lo esté pero su cortafuegos
            //impide conexiones
            //...
        }
    }
}
