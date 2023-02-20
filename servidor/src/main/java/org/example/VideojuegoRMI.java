package org.example;

import org.example.clases.Videojuego;
import org.example.interfaces.VideojuegoInterfaceRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

public class VideojuegoRMI extends UnicastRemoteObject implements VideojuegoInterfaceRMI {
    private static final long serialVersionUID = -4817856459999901795L;
    private ArrayList<Videojuego> videojuegos;
    public VideojuegoRMI() throws RemoteException {
        videojuegos= new ArrayList<Videojuego>();
        //EMPIEZA LA CONEXION A LA BASE DE DATOS

        // Paso 1: Cargar el driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver para MySQL");
            return;
        }
        System.out.println("Se ha cargado el Driver de MySQL");
        // Paso 2: Establecer conexión con la base de datos
        String cadenaConexion = "jdbc:mysql://localhost:3306/videojuegos";
        String user = "root";
        String pass = "curso";
        Connection con;
        try {
            con = DriverManager.getConnection(cadenaConexion, user, pass);
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la BD");
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Se ha establecido la conexión con la Base de datos");

        // Paso 3: Interactuar con la BD (todavía pendiente)
        try {
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM  videojuego");

            while (rs.next()) {
                String id= (rs.getString("id"));
                String nombre= (rs.getString("nombre"));
                String ano_lanzamiento=(rs.getString("ano_lanzamiento"));
                String desarrollador=(rs.getString("desarrollador"));
                String plataforma=(rs.getString("plataforma"));
                String genero=(rs.getString("genero"));
                String puntuacion=(rs.getString("puntuacion"));
                //PARSEAR LOS NECESARIOS
                int idBueno = Integer.parseInt(id);
                int anoLazamientoBueno= Integer.parseInt(ano_lanzamiento);
                float puntuacionBueno=Float.parseFloat(puntuacion);
                videojuegos.add(new Videojuego(idBueno,nombre,anoLazamientoBueno,desarrollador,plataforma,genero,puntuacionBueno));
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de productos");
            System.out.println(e.getMessage());
        }
        // Paso 4: Cerrar la conexión

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido cerrar la conexión con la BD");
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Se ha cerrado la base de datos");

        //TERMINA LA CONEXION A LA BASE DE DATOS

    }
    @Override

    public String buscarId(int id) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getId()==id) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override
    public String buscarNombre(String nombre) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getNombre().contains(nombre)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override

    public String buscarAnoLanzamiento(int ano_lanzamiento) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getAno_lanzamiento()==ano_lanzamiento) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override

    public String buscarDesarrollador(String desarrollador) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getDesarollador().contains(desarrollador)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override

    public String buscarGenero(String genero) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getGenero().contains(genero)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override

    public String buscarPlataforma(String plataforma) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getPlataforma().contains(plataforma)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
     
    @Override
    public String buscarPuntuacion(Float puntuacion) throws RemoteException {
        String resultado = "";
        for (Videojuego c : videojuegos) {
            if (c.getPuntuacion()==puntuacion) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }


}
