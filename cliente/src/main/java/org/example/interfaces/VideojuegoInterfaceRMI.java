package org.example.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VideojuegoInterfaceRMI extends Remote {
    public String buscarId(int id) throws RemoteException;
    public String buscarNombre(String nombre) throws RemoteException;
    public String buscarAnoLanzamiento(int ano_lanzamiento) throws RemoteException;
    public String buscarDesarrollador(String desarrollador) throws RemoteException;
    public String buscarGenero(String genero) throws RemoteException;
    public String buscarPlataforma(String plataforma) throws RemoteException;
    public String buscarPuntuacion(Float puntuacion) throws RemoteException;
}
