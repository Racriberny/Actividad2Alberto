package com.cristobalbernal.Actividad2Alberto.Servidor;

import com.cristobalbernal.Actividad2Alberto.Hilo.HiloConexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public void servir() {
        ServerSocket serverSocket;
        final int PUERTO = 9876;
        try {
            System.out.println("Servidor iniciado!!!");
            serverSocket = new ServerSocket(PUERTO);
            while (true) {

                Socket conexion;
                conexion = serverSocket.accept();
                HiloConexion hiloConexion;
                hiloConexion = new HiloConexion(conexion);
                Thread hilo = new Thread(hiloConexion);
                hilo.start();
            }
        } catch (IOException e) {
            System.out.println("Nada!!!");
        }
    }

    public static void main(String[] args) {
        Servidor servidor;
        servidor = new Servidor();
        servidor.servir();
    }
}
