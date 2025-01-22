package DAO;
import entities.Animales;
import entities.Usuarios;

import java.util.List;
public interface InterfazAnimales {

    /**
     *
     * @return todas las personas
     */

    List<Animales> findAll();

    //@return devuelve un empleado por un id concreto
    Animales findById(int id);

    //@return devuelve mas de un  empleado por un name concreto
    List<Animales> findByName(String name);


    //inserta un nuevo registro
    Animales create(Animales animales);



    //actualiza un registro
    Animales update(Animales animales);

    /**
     *
     * @param id
     */

    boolean delete(int id);
}

