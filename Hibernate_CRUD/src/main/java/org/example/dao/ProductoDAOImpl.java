package org.example.dao;

import org.example.entity.Producto;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void guardar(Producto producto) {
        // El try externo solo maneja la apertura y cierre automático de la sesión
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            // El try interno maneja la transacción y los posibles errores SQL
            try {
                transaction = session.beginTransaction();
                session.persist(producto);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback(); // Ahora el rollback funciona porque la sesión sigue abierta
                }
                System.err.println("\n--- ERROR REAL AL GUARDAR ---");
                e.printStackTrace();
            }
        }
    }

    @Override
    public Producto obtenerPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Producto.class, id);
        }
    }

    @Override
    public List<Producto> obtenerTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Producto", Producto.class).list();
        }
    }

    @Override
    public void actualizar(Producto producto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.merge(producto);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.err.println("\n--- ERROR REAL AL ACTUALIZAR ---");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Producto producto = session.get(Producto.class, id);
                if (producto != null) {
                    session.remove(producto);
                    System.out.println("Producto eliminado con éxito.");
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.err.println("\n--- ERROR REAL AL ELIMINAR ---");
                e.printStackTrace();
            }
        }
    }
}