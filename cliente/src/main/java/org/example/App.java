package org.example;

import org.example.interfaces.VideojuegoInterfaceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            registry = LocateRegistry.getRegistry("192.168.1.13", 5055);
            System.out.println("Hemos obtenido el registro");
            VideojuegoInterfaceRMI vdg = (VideojuegoInterfaceRMI) registry.lookup("miMusica");
            System.out.println("Hemos obtenido el objeto remoto");
            System.out.println(); // Retorno de carro.
            String buscado;
            String opcion;
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "1":
                        System.out.println("Escribe id del videojuego a buscar: ");
                        buscado = lector.nextLine();
                        System.out.println(vdg.buscarId(Integer.parseInt(buscado)));
                        break;
                    case "2":
                        System.out.println("Escribe nombre del videojuego a buscar: ");
                       String nombre = lector.nextLine();
                        System.out.println(vdg.buscarNombre(nombre));
                        break;
                    case "3":
                        System.out.println("Escribe un año para ver los videojuegos lanzados ese año: ");
                        String ano = lector.nextLine();
                        System.out.println(vdg.buscarAnoLanzamiento(Integer.parseInt(ano)));
                        break;
                    case "4":
                        System.out.println("Escribe nombre de algun desarrollador: ");
                        String desarrollador = lector.nextLine();
                        System.out.println(vdg.buscarDesarrollador(desarrollador));
                        break;
                    case "5":
                        System.out.println("Escriba un genero de videjuego ");
                        String genero = lector.nextLine();
                        System.out.println(vdg.buscarGenero(genero));
                        break;
                    case "6":
                        System.out.println("Escriba una plataforma: ");
                        String plataforma = lector.nextLine();
                        System.out.println(vdg.buscarPlataforma(plataforma));
                        break;
                    case "7":
                        System.out.println("Escribe una puntuacion: ");
                        String pnt = lector.nextLine();
                        System.out.println(vdg.buscarPuntuacion(Float.valueOf(pnt)));
                        break;
                    case "8":
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("8"));
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();


} // CIERRA MAIN ARGS

    private static void escribirMenu() {
        System.out.println();
        System.out.println("Búsqueda de videojuegos");
        System.out.println("--------------------------");
        System.out.println("1 = POR ID");
        System.out.println("2 = Por NOMBRE");
        System.out.println("3 = AÑO LANZAMIENTO");
        System.out.println("4 = DESARROLLADOR");
        System.out.println("5 = GENERO");
        System.out.println("6 = PLATAFORMA");
        System.out.println("7 = PUNTUACION");
        System.out.println("8 = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }


}
