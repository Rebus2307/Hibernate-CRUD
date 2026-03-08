package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Instancia única y estática de SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crea la SessionFactory a partir del hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Registra la excepción para que no falle silenciosamente
            System.err.println("Fallo la creación inicial de SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método público para obtener la fábrica desde cualquier parte del código
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Método para cerrar las conexiones cuando la aplicación se detenga
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}