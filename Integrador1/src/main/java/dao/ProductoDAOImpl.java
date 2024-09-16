package dao;

import models.Articulos;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void crearProducto(Articulos producto) {
        String sql = "INSERT INTO productos (codigo, descripcion, precioVenta, stock) VALUES (?, ?, ?, ?)";
        Connection conn = ConexionBD.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, producto.getCodigo());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecioVenta());
            pstmt.setInt(4, producto.getStock());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Articulos obtenerProducto(String codigo) {
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        Articulos producto = null;
        Connection conn = ConexionBD.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                producto = new Articulos(
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getFloat("precioVenta"),
                        rs.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void actualizarProducto(Articulos producto) {
        String sql = "UPDATE productos SET descripcion = ?, precioVenta = ?, stock = ? WHERE codigo = ?";
        Connection conn = ConexionBD.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, producto.getDescripcion());
            pstmt.setDouble(2, producto.getPrecioVenta());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(String codigo) {
        String sql = "DELETE FROM productos WHERE codigo = ?";
        Connection conn = ConexionBD.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Articulos> listarProductos() {
        String sql = "SELECT * FROM productos";
        List<Articulos> productos = new ArrayList<>();
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Articulos producto = new Articulos(
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getFloat("precioVenta"),
                        rs.getInt("stock")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
