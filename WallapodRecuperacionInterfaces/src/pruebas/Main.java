package pruebas;

import java.util.List;

import interfaces.IMercado;
import interfaces.IProducto;
import interfaces.IUsuario;
import model.Mercado;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        // Crear usuarios
        IUsuario usuario1 = new Usuario("Usuario1");
        IUsuario usuario2 = new Usuario("Usuario2");

        // Crear mercado
        IMercado mercado = new Mercado();

        // Prueba subirProducto y getProductos
        mercado.subirProducto("Producto1", 10.0, usuario1);
        mercado.subirProducto("Producto2", 15.0, usuario1);
        mercado.subirProducto("Producto3", 20.0, usuario2);

        List<IProducto> productos = mercado.getProductos();
        System.out.println("Productos registrados:");
        for (IProducto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Usuario: " + producto.getUsuario().getNombre());
        }
       

        // Prueba getFiltrarProductosPorPrecio
        List<IProducto> productosFiltrados = mercado.getFiltrarProductosPorPrecio(10.0, 15.0);
        System.out.println("Productos filtrados por precio:");
        for (IProducto producto : productosFiltrados) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
       

        // Prueba getProductosVisiblesOrdenados
        List<IProducto> productosVisibles = mercado.getProductosVisiblesOrdenados();
        System.out.println("Productos visibles ordenados por precio:");
        for (IProducto producto : productosVisibles) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
       

        // Prueba removeProducto
        IUsuario propietario = mercado.removeProducto("Producto2");
        System.out.println("Usuario propietario del producto eliminado: " + propietario.getNombre());
       

        // Verificar productos después de eliminar uno
        productos = mercado.getProductos();
        System.out.println("Productos registrados después de eliminar uno:");
        for (IProducto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Usuario: " + producto.getUsuario().getNombre());
        }
    }
}
