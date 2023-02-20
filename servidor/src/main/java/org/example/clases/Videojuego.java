package org.example.clases;

public class Videojuego {

    private int id;
    private String nombre;
    private int ano_lanzamiento;
    private String desarollador;
    private String plataforma;
    private String genero;
    private float puntuacion;


    public Videojuego(int id, String nombre, int ano_lanzamiento, String desarollador, String plataforma, String genero, float puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.ano_lanzamiento = ano_lanzamiento;
        this.desarollador = desarollador;
        this.plataforma = plataforma;
        this.genero = genero;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAno_lanzamiento() {
        return ano_lanzamiento;
    }

    public void setAno_lanzamiento(int ano_lanzamiento) {
        this.ano_lanzamiento = ano_lanzamiento;
    }

    public String getDesarollador() {
        return desarollador;
    }

    public void setDesarollador(String desarollador) {
        this.desarollador = desarollador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ano_lanzamiento=" + ano_lanzamiento +
                ", desarollador='" + desarollador + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", genero='" + genero + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
