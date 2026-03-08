package org.example;

import org.example.dao.ProductoDAO;
import org.example.dao.ProductoDAOImpl;
import org.example.entity.Producto;
import org.example.util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciamos nuestra implementación del DAO
        ProductoDAO productoDAO = new ProductoDAOImpl();

        System.out.println("=========================================");
        System.out.println(" INICIANDO PRUEBAS CRUD CON HIBERNATE");
        System.out.println("=========================================\n");

        // --------------------------------------------------------
        // 1. CREATE (Guardar)
        // --------------------------------------------------------
        System.out.println("--- 1. CREANDO PRODUCTOS ---");
        Producto p1 = new Producto("Laptop Gamer", 1500.50, 10);
        Producto p2 = new Producto("Teclado Mecánico", 45.99, 30);

        productoDAO.guardar(p1);
        productoDAO.guardar(p2);
        System.out.println("Productos guardados en la base de datos.\n");

        // --------------------------------------------------------
        // 2. READ ALL (Leer todos)
        // --------------------------------------------------------
        System.out.println("--- 2. LEYENDO TODOS LOS PRODUCTOS ---");
        List<Producto> productos = productoDAO.obtenerTodos();
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
        System.out.println();

        // --------------------------------------------------------
        // 3. READ ONE (Leer por ID)
        // --------------------------------------------------------
        System.out.println("--- 3. LEYENDO PRODUCTO POR ID (Suponiendo ID = 1) ---");
        Producto productoEncontrado = productoDAO.obtenerPorId(1);
        if (productoEncontrado != null) {
            System.out.println("Encontrado: " + productoEncontrado.getNombre() + "\n");
        } else {
            System.out.println("El producto no existe.\n");
        }

        // --------------------------------------------------------
        // 4. UPDATE (Actualizar)
        // --------------------------------------------------------
        System.out.println("--- 4. ACTUALIZANDO PRODUCTO (ID = 1) ---");
        if (productoEncontrado != null) {
            // Modificamos el objeto en memoria
            productoEncontrado.setPrecio(1350.00);
            productoEncontrado.setStock(8);

            // Mandamos a actualizar en la BD
            productoDAO.actualizar(productoEncontrado);
            System.out.println("Producto actualizado. Nuevos datos: " + productoDAO.obtenerPorId(1) + "\n");
        }

        // --------------------------------------------------------
        // 5. DELETE (Eliminar)
        // --------------------------------------------------------
        System.out.println("--- 5. ELIMINANDO PRODUCTO (ID = 2) ---");
        productoDAO.eliminar(2);

        System.out.println("\n--- LISTA FINAL DE PRODUCTOS ---");
        for (Producto p : productoDAO.obtenerTodos()) {
            System.out.println(p.toString());
        }

        // --------------------------------------------------------
        // CIERRE DE FÁBRICA
        // --------------------------------------------------------
        // Es vital cerrar la SessionFactory para liberar recursos y que la app termine correctamente
        HibernateUtil.shutdown();
        System.out.println("\nConexiones cerradas. Fin de la prueba.");
    }
}