package DAO;

import entities.Usuarios;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InterfazUsuariosImplTest {
    private final InterfazUsuariosImpl dao = new InterfazUsuariosImpl();

    @Test
    void testFindAll() {
        List<Usuarios> usuarios = dao.findAll();
        assertNotNull(usuarios, "La lista de usuarios no debería ser nula");
    }

    @Test
    void testFindById() {
        Usuarios usuario = dao.findById(1);
        assertNotNull(usuario, "El usuario con ID 1 debería existir");
    }

    @Test
    void testFindByName() {
        List<Usuarios> usuarios = dao.findByName("Tom");
        assertFalse(usuarios.isEmpty(), "Debería haber al menos un usuario llamado Tom");
    }

    @Test
    void testCreate() {
        Usuarios nuevoUsuario = new Usuarios(null, "Eleonora", 28, "Florencia");
        Usuarios creado = dao.create(nuevoUsuario);
        assertNotNull(creado, "El usuario debería haberse creado");
        assertEquals("Eleonora", creado.getNombre(), "El nombre debería coincidir");
    }


    @Test
    void testUpdate() {
        Usuarios usuario = dao.findById(1);
        usuario.setNombre("Laura");
        Usuarios actualizado = dao.update(usuario);
        assertEquals("Laura", actualizado.getNombre(), "El nombre del usuario debería actualizarse a Laura");
    }
}