package DAO;
import entities.Usuarios;
import java.util.List;

public interface InterfazUsuarios {

    /**
     *
     * @return todas las personas
     */

    List<Usuarios> findAll();

    //@return devuelve un empleado por un id concreto
    Usuarios findById(int id);

    //@return devuelve mas de un  empleado por un name concreto
    List<Usuarios> findByName(String name);


    //inserta un nuevo registro
    Usuarios create(Usuarios persona);



    //actualiza un registro
    Usuarios update(Usuarios persona);

    /**
     *
     * @param id
     */

    boolean delete(int id);
}
