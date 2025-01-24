package DAO;

import entities.Animales;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * Implementación de la interfaz InterfazAnimales para gestionar operaciones CRUD sobre la entidad Animales.
 */
public class InterfazAnimalesImpl implements InterfazAnimales {

    /**
     * Obtiene una sesión de Hibernate.
     * @return una instancia de Session para interactuar con la base de datos.
     */
    private Session obtenerSesion() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
    }

    /**
     * Recupera todos los registros de la entidad Animales.
     * @return una lista de objetos Animales.
     */
    @Override
    public List<Animales> findAll() {
        Session session = obtenerSesion();
        List<Animales> animales = session.createQuery("FROM Animales", Animales.class).list();
        session.close();
        return animales;
    }

    /**
     * Recupera un animal por su id.
     * @param id Id del animal.
     * @return el objeto Animales correspondiente al ID.
     */
    @Override
    public Animales findById(int id) {
        Session session = obtenerSesion();
        Animales animal = session.get(Animales.class, id);
        session.close();
        return animal;
    }

    /**
     * Busca animales por nombre.
     * @param name Nombre del animal.
     * @return una lista de objetos Animales que coinciden con el nombre.
     */
    @Override
    public List<Animales> findByName(String name) {
        Session session = obtenerSesion();
        List<Animales> animales = session.createQuery("FROM Animales WHERE nombre = :nombre", Animales.class)
                .setParameter("nombre", name)
                .list();
        session.close();
        return animales;
    }

    /**
     * Busca animales por especie.
     * @param especie Especie del animal.
     * @return una lista de objetos Animales que coinciden con la especie.
     */
    @Override
    public List<Animales> findByEspecie(String especie) {
        Session session = obtenerSesion();
        List<Animales> animales = session.createQuery("FROM Animales WHERE especie = :especie", Animales.class)
                .setParameter("especie", especie)
                .list();
        session.close();
        return animales;
    }

    /**
     * Guarda un nuevo animal en la base de datos.
     * @param animal el objeto Animales a ser guardado.
     * @return el objeto Animales guardado.
     */
    @Override
    public Animales create(Animales animal) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        session.persist(animal);
        tx.commit();
        session.close();
        return animal;
    }

    /**
     * Actualiza un registro existente en la base de datos.
     * @param animal el objeto Animales con los datos actualizados.
     * @return el objeto Animales actualizado.
     */
    @Override
    public Animales update(Animales animal) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        session.merge(animal);
        tx.commit();
        session.close();
        return animal;
    }


}
