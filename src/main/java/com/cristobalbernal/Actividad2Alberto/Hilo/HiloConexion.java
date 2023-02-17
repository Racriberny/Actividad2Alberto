package com.cristobalbernal.Actividad2Alberto.Hilo;

import com.cristobalbernal.Actividad2Alberto.Utilidades.Lib;
import com.cristobalbernal.Actividad2Alberto.Utilidades.Sumador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloConexion implements Runnable {
    BufferedReader bfr;

    PrintWriter pw;

    Socket socket;

    public HiloConexion(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            bfr = Lib.getFlujoLectura(this.socket);
            pw = Lib.getFlujoEscritura(this.socket);
            String lineaRecibida;
            lineaRecibida = bfr.readLine();
            String sumaUna;
            String sumaDos;
            String sumaTres;
            sumaUna = bfr.readLine();
            sumaDos = bfr.readLine();
            sumaTres = bfr.readLine();
            int sumaRealizadaUno = Sumador.sumar(sumaUna);
            int sumaRealizadaDos = Sumador.sumar(sumaDos);
            int sumaRealizadaTres = Sumador.sumar(sumaTres);
            System.out.println(Thread.currentThread().getName() + " recibio:" + lineaRecibida);
            pw.println(sumaRealizadaUno);
            pw.println(sumaRealizadaDos);
            pw.println(sumaRealizadaTres);
            pw.flush();
        } catch (IOException e) {
            System.out.println("Hubo un fallo al enviar/recibir datos");
        }
    }
    //Fin del run
}
