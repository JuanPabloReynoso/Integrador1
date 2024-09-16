package dao;

import models.Articulos;
import java.util.List;

public interface ProductoDAO {
    void crearProducto(Articulos producto);
    Articulos obtenerProducto(String codigo);
    void actualizarProducto(Articulos producto);
    void eliminarProducto(String codigo);
    List<Articulos> listarProductos();
}
