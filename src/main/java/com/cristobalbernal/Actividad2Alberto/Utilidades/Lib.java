package com.cristobalbernal.Actividad2Alberto.Utilidades;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Lib {
    private static final Scanner lector = new Scanner(System.in);
    public static PrintWriter getFlujoEscritura(Socket socket) throws IOException{
        OutputStream os=socket.getOutputStream();
        return new PrintWriter(os);
    }
    public static BufferedReader getFlujoLectura(Socket s) throws IOException {
        InputStream is=s.getInputStream();
        InputStreamReader isr= new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    public static String leerLinea() {
        return lector.nextLine();
    }


}
