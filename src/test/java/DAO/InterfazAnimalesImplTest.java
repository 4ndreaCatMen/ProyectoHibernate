package DAO;

import entities.Animales;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InterfazAnimalesImplTest {
    private final InterfazAnimalesImpl dao = new InterfazAnimalesImpl();

    @Test
    void testFindAll() {
        List<Animales> animales = dao.findAll();
        assertNotNull(animales, "La lista de animales no debería ser nula");
    }

    @Test
    void testFindById() {
        Animales animal = dao.findById(1);
        assertNotNull(animal, "El animal con ID 1 debería existir");
    }

    @Test
    void testFindByName() {
        List<Animales> animales = dao.findByName("Basura");
        assertFalse(animales.isEmpty(), "Debería haber al menos un animal llamado Basura");
    }

    @Test
    void testCreate() {
        Animales nuevoAnimal = new Animales(null, "Salchicha", "Perro", "Comestible", 3, "Recien abandonado");
        Animales creado = dao.create(nuevoAnimal);
        assertNotNull(creado, "El animal debería haberse creado");
        assertEquals("Salchicha", creado.getNombre(), "El nombre debería coincidir");
    }


    @Test
    void testUpdate() {
        Animales animal = dao.findById(1);
        animal.setNombre("Bobby");
        Animales actualizado = dao.update(animal);
        assertEquals("Bobby", actualizado.getNombre(), "El nombre del animal debería actualizarse a Bobby");
    }
}