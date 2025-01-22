package entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Representa una familia de acogida de animales.
 */
@Entity
@Table(name = "Usuario")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Integer edad;
    private String ciudad;

    /* Una familia puede cuidar a varios animales, así que un usuario (familia)
     puede tener una lista de animales a su cargo (relación de uno a muchos).
     "mappedBy = usuario" la relación ya está definida en la clase Animales.
     La opción cascade hace que si se borra la familia, también se borren sus animales.*/

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) // Una familia puede tener varios animales.
    private List<Animales> animales;

    public Usuarios() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id     Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param edad   Edad del usuario.
     * @param ciudad Ciudad del usuario.
     */
    public Usuarios(Integer id, String nombre, Integer edad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public Integer getId() {
        return id; }
    public void setId(Integer id) {
        this.id = id; }

    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public Integer getEdad() {
        return edad; }
    public void setEdad(Integer edad) {
        this.edad = edad; }

    public String getCiudad() {
        return ciudad; }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad; }

    public List<Animales> getAnimales() {
        return animales; }
    public void setAnimales(List<Animales> animales) {
        this.animales = animales; }
}
