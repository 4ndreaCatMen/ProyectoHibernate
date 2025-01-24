package DAO;

import entities.Animales;
import java.util.List;

public interface InterfazAnimales {
    List<Animales> findAll();
    Animales findById(int id);
    List<Animales> findByName(String name);
    Animales create(Animales animales);
    Animales update(Animales animales);
    boolean delete(int id);
}
