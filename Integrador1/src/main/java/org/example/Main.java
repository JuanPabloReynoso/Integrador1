package org.example;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import models.Articulos;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductoDAO productoDAO = new ProductoDAOImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1. Agregar producto");
            System.out.println("2. Ver producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Listar productos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    verProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    listarProductos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    private static void agregarProducto() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio de venta: ");
        float precioVenta = scanner.nextFloat();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        Articulos producto = new Articulos(codigo, descripcion, precioVenta, stock);
        productoDAO.crearProducto(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    private static void verProducto() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        Articulos producto = productoDAO.obtenerProducto(codigo);
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void actualizarProducto() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Nuevo precio de venta: ");
        float precioVenta = scanner.nextFloat();
        System.out.print("Nuevo stock: ");
        int stock = scanner.nextInt();

        Articulos producto = new Articulos(codigo, descripcion, precioVenta, stock);
        productoDAO.actualizarProducto(producto);
        System.out.println("Producto actualizado exitosamente.");
    }

    private static void eliminarProducto() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        productoDAO.eliminarProducto(codigo);
        System.out.println("Producto eliminado exitosamente.");
    }

    private static void listarProductos() {
        List<Articulos> productos = productoDAO.listarProductos();
        for (Articulos producto : productos) {
            System.out.println(producto);
        }
    }
}
