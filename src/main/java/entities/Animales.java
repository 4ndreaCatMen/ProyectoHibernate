package entities;

import jakarta.persistence.*;

import java.io.Serializable;



@Entity
@Table(name = "Animal")
public class Animales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String especie;
    private String descripcion;


    public Animales(Integer id, String nombre,String especie, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.descripcion = descripcion;

    }

    public Animales() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion =descripcion;
    }



}


