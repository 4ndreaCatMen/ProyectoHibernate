package Util;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {

    @Test
    void testSessionFactoryNotNull() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        assertNotNull(sessionFactory, "La fábrica de sesiones de Hibernate no debería ser nula");
    }


    @Test
    void testShutdown() {
        HibernateUtil.shutdown();
        assertTrue(HibernateUtil.getSessionFactory().isClosed(), "La fábrica de sesiones debería estar cerrada");
    }
}
