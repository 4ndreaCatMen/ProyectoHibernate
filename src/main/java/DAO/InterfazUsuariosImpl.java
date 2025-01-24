package DAO;

import entities.Usuarios;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class InterfazUsuariosImpl implements InterfazUsuarios {

    private Session obtenerSesion() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
    }

    @Override
    public List<Usuarios> findAll() {
        Session session = obtenerSesion();
        List<Usuarios> usuarios = session.createQuery("FROM Usuarios", Usuarios.class).list();
        session.close();
        return usuarios;
    }

    @Override
    public Usuarios findById(int id) {
        Session session = obtenerSesion();
        Usuarios usuario = session.get(Usuarios.class, id);
        session.close();
        return usuario;
    }

    @Override
    public List<Usuarios> findByName(String name) {
        Session session = obtenerSesion();
        List<Usuarios> usuarios = session.createQuery("FROM Usuarios WHERE nombre = :nombre", Usuarios.class)
                .setParameter("nombre", name)
                .list();
        session.close();
        return usuarios;
    }

    @Override
    public Usuarios create(Usuarios usuario) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        session.persist(usuario);
        tx.commit();
        session.close();
        return usuario;
    }

    @Override
    public Usuarios update(Usuarios usuario) {
        Session session = obtenerSesion();
        Transaction tx = session.beginTransaction();
        session.merge(usuario);
        tx.commit();
        session.close();
        return usuario;
    }

}
