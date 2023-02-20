package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {
    public static void main(String[] args) {
        String host;
        int puerto = 5055;
        try {
            host = InetAddress.getLocalHost().getHostAddress(); // con esto cogemos nuestra ip
        } catch (UnknownHostException e) {
            System.out.println("No se ha podido obtener la dirección IP");
            System.out.println(e.getMessage());
            return;
        }
        try {
            //GUARDAR EL OBJETO EN EL REGISTRO
            Registry registro = LocateRegistry.createRegistry(puerto);
            VideojuegoRMI videojuego = new VideojuegoRMI ();
            // INSCRIBIR EL OBJETO EN EL REGISTRO
            registro.rebind("miMusica", videojuego);
            System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
        } catch (RemoteException e) {
            System.out.println("No se ha podido registrar el servicio");
            System.out.println(e.getMessage());
        }
    }
}

