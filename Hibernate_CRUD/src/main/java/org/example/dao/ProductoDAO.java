package org.example.dao;

import org.example.entity.Producto;
import java.util.List;

public interface ProductoDAO {
    void guardar(Producto producto);        // Create
    Producto obtenerPorId(int id);          // Read
    List<Producto> obtenerTodos();          // Read (All)
    void actualizar(Producto producto);     // Update
    void eliminar(int id);                  // Delete
}