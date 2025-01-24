package DAO;

import entities.Animales;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class InterfazAnimalesImpl implements InterfazAnimales {

    private Session obtenerSesion() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
    }

    @Override
    public List<Animales> findAll() {
        Session session = obtenerSesion();
        List<Animales> animales = session.createQuery("FROM Animales", Animales.class).list();
        session.close();
        return animales;
    }

    @Override
    public Animales findById(int id) {
        Session session = obtenerSesion();
        Animales animal = session.get(Animales.class, id);
        session.close();
        return animal;
    }

    @Override
    public List<Animales> findByName(String name) {
        Session session = obtenerSesion();
        List<Animales> animales = session.createQuery("FROM Animales WHERE nombre = :nombre", Animales.class)
                .setParameter("nombre", name)
                .list();
        session.close();
        return animales;
    }

    @Override
    public List<Animales> findByEspecie(String especie) {
        Session session = obtenerSesion();
        List<Animales> animales = session.createQuery("FROM Animales WHERE especie = :especie", Animales.class)
                .setParameter("especie", especie)
                .list();
        session.close();
        return animales;
    }


    @Override
    public Animales create(Animales animal) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        session.persist(animal);
        tx.commit();
        session.close();
        return animal;
    }

    @Override
    public Animales update(Animales animal) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        session.merge(animal);
        tx.commit();
        session.close();
        return animal;
    }

    @Override
    public boolean delete(int id) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        Animales animal = session.get(Animales.class, id);
        if (animal != null) {
            session.delete(animal);
            tx.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}
