package entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Representa a un animal en el refugio.
 */
@Entity
@Table(name = "Animal")
public class Animales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especie;
    private String descripcion;
    private int edad;
    private String estado;

    // Cada animal puede tener una familia que lo cuide.
    // Muchos animales pueden estar con una misma familia (relación de muchos a uno).
    // La columna "usuario_id" en la tabla de animales guardará quién lo está cuidando.
    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuarios usuario;

    // Constructor vacío requerido por Hibernate
    public Animales() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id          Identificador del animal.
     * @param nombre      Nombre del animal.
     * @param especie     Especie del animal.
     * @param descripcion Descripción de cómo se perdió.
     * @param edad        Edad del animal.
     * @param estado      Estado actual del animal.
     */
    public Animales(Integer id, String nombre, String especie, String descripcion, int edad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.descripcion = descripcion;
        this.edad = edad;
        this.estado = estado;

    }

    // Getters y Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public String getEspecie() {
        return especie; }
    public void setEspecie(String especie) {
        this.especie = especie; }

    public String getDescripcion() {
        return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; }

    public int getEdad() {
        return edad; }
    public void setEdad(int edad) {
        this.edad = edad; }

    public String getEstado() {
        return estado; }
    public void setEstado(String estado) {
        this.estado = estado; }
}
