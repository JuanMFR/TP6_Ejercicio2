/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author JuanmaPC
 */
public class GestionProductos {
    private static TreeSet<Producto> productos = new TreeSet<>();

    static {
        // Productos de ejemplo
        productos.add(new Producto(2351, "Poco Robame", 8599.75, 12, "Perfumería"));
        productos.add(new Producto(1234, "Arroz Gallo", 1250.50, 25, "Comestible"));
        productos.add(new Producto(3456, "Lavandina Ayudín", 890.00, 30, "Limpieza"));
        productos.add(new Producto(4567, "Ibuprofeno 600", 450.75, 50, "Perfumería"));
        productos.add(new Producto(5678, "Fideos Matarazzo", 980.25, 40, "Comestible"));
    }

    public static boolean agregarProducto(Producto producto) {
        return productos.add(producto);
    }

    public static boolean eliminarProducto(int codigo) {
        return productos.removeIf(p -> p.getCodigo() == codigo);
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static boolean actualizarProducto(Producto producto) {
        Producto existente = buscarProducto(producto.getCodigo());
        if (existente != null) {
            productos.remove(existente);
            productos.add(producto);
            return true;
        }
        return false;
    }

    public static List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    public static List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();
        String busqueda = nombre.toLowerCase();
        for (Producto p : productos) {
            if (p.getDescripcion().toLowerCase().contains(busqueda)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public static List<Producto> buscarPorRubro(String rubro) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getRubro().equals(rubro)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public static List<Producto> buscarPorRangoPrecio(double min, double max) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public static boolean existeCodigo(int codigo) {
        return buscarProducto(codigo) != null;
    }
}
