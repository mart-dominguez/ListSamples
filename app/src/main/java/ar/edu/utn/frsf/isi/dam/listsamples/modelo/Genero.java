package ar.edu.utn.frsf.isi.dam.listsamples.modelo;

public class Genero {
    private Integer id;
    private String nombre;
    private static Genero[] arregloGenero;

    public Genero() {
    }

    public Genero(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static Genero[] lista(){
        if(arregloGenero==null) {
            arregloGenero = new Genero[6];
            arregloGenero[0] = new Genero(1, "Accion");
            arregloGenero[1] = new Genero(2, "Policial");
            arregloGenero[2] = new Genero(3, "Comedia");
            arregloGenero[3] = new Genero(4, "Drama");
            arregloGenero[4] = new Genero(5, "Suspenso");
            arregloGenero[5] = new Genero(6, "Terror");
        }
        return arregloGenero;
    }

}
