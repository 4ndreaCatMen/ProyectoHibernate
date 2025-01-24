package DAO;

import entities.Usuarios;
import java.util.List;

public interface InterfazUsuarios {
    List<Usuarios> findAll();
    Usuarios findById(int id);
    List<Usuarios> findByName(String name);
    Usuarios create(Usuarios usuario);
    Usuarios update(Usuarios usuario);
    boolean delete(int id);
}
