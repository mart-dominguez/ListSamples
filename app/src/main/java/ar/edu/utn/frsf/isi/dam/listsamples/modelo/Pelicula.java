package ar.edu.utn.frsf.isi.dam.listsamples.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pelicula {
    private Integer id;
    private String nombre;
    private Integer calificacion;
    private Boolean favorita;
    private Genero genero;
    private static List<Pelicula> lista;
    public Pelicula() {
        favorita = false;
        calificacion=1;
    }

    public Pelicula(Integer id, String nombre, Integer calificacion, Boolean favorita, Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.favorita = favorita;
        this.genero = genero;
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

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getFavorita() {
        return favorita;
    }

    public void setFavorita(Boolean favorita) {
        this.favorita = favorita;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id, pelicula.id) &&
                Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static List<Pelicula> lista(){
        if(lista==null){
            Genero[] listaGeneros = Genero.lista();
            lista = new ArrayList<>();
            lista.add(new Pelicula(1,"Breaking Bad",5,true,listaGeneros[1]));
            lista.add(new Pelicula(2,"Billions",4,false,listaGeneros[3]));
            lista.add(new Pelicula(3,"Shooter",3,true,listaGeneros[4]));
            lista.add(new Pelicula(4,"Game of Thrones",5,false,listaGeneros[2]));
            lista.add(new Pelicula(5,"The Killing",4,false,listaGeneros[5]));
            lista.add(new Pelicula(6,"Vikings",2,true,listaGeneros[0]));
            lista.add(new Pelicula(7,"Peaky Blinders",4,true,listaGeneros[1]));
            lista.add(new Pelicula(8,"The Sopranos",5,false,listaGeneros[0]));
            lista.add(new Pelicula(9,"Lost",3,true,listaGeneros[2]));
            lista.add(new Pelicula(10,"La casa de papel",3,true,listaGeneros[3]));
            lista.add(new Pelicula(11,"House of Cards",2,false,listaGeneros[4]));
            lista.add(new Pelicula(12,"Westworld",2,true,listaGeneros[5]));
            lista.add(new Pelicula(13,"Ozark",4,true,listaGeneros[5]));
            lista.add(new Pelicula(14,"The Blacklist",4,false,listaGeneros[4]));
            lista.add(new Pelicula(15,"Ray Donovan",1,true,listaGeneros[3]));
            lista.add(new Pelicula(16,"Scandal",2,true,listaGeneros[2]));
            lista.add(new Pelicula(17,"Daredevil",3,false,listaGeneros[0]));
            lista.add(new Pelicula(18,"Fariña",3,true,listaGeneros[1]));
            lista.add(new Pelicula(19,"Wild Wild County",5,false,listaGeneros[0]));
            lista.add(new Pelicula(20,"The Following",2,true,listaGeneros[5]));
            lista.add(new Pelicula(21,"Better Call Saul",1,false,listaGeneros[3]));
            lista.add(new Pelicula(22,"The West Wing",1,true,listaGeneros[4]));
        }
        return lista;
    }
}
