package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.IMercado;
import interfaces.IProducto;
import interfaces.IUsuario;

public class Mercado implements IMercado{

	
    private List<IProducto> productos;//lista de productos

    public Mercado() {
        productos = new ArrayList<>();//lista de productos vacia
    }

	@Override
	public boolean subirProducto(String nombre, double precio, IUsuario usuario) {
		for (IProducto producto : productos) {//por cada uno de los productos
            if (producto.getNombre().equals(nombre)) {//que tengan el mismo nombre
                return false; // El producto ya está registrado
            }
        }
        IProducto nuevoProducto = new Producto(nombre, precio, usuario);//genero un nuevo producto
        productos.add(nuevoProducto);//añadimos el nuevo producto
        return true;
    }

	

	@Override
	public List<IProducto> getProductos() {
	
		return productos;
	}

	@Override
	public List<IProducto> getFiltrarProductosPorPrecio(double min, double max) {
		List<IProducto> productosFiltrados = new ArrayList<>();//lista de los productos filtrados
        for (IProducto producto : productos) {//por cada uno de los productos
            double precio = producto.getPrecio();//vemos el precio
            if (precio >= min && precio <= max) {//si es mayor o igual que el minimo y precio es menor o igual que el max
                productosFiltrados.add(producto);//el producto filtrado se añade a la lista
            }
        }
        return productosFiltrados;//se ven la lista de productos filtrados
    }

	

	@Override
	public List<IProducto> getProductosVisiblesOrdenados() {
		List<IProducto> productosVisibles = new ArrayList<>();//Se creo la lista vacia de productos visibles
        for (IProducto producto : productos) {//recorro los productos
            if (!producto.getCaducado()) {//si el producto no está caducado
                productosVisibles.add(producto);//lo aado a la lista
            }
        }
        Collections.sort(productosVisibles);//se ordenan los productos visibles
        return productosVisibles;
    }


	@Override
	public IUsuario removeProducto(String nombre) {

        for (int i = 0; i < productos.size(); i++) {//recorro la dimensión de productos
            IProducto producto = productos.get(i);//y consiguo el indice i
            if (producto.getNombre().equals(nombre)) {
                IUsuario propietario = producto.getUsuario();
                productos.remove(i);//se elimina el producto
                return propietario;//usuario propietario del producto que se eliminó
            }
        }
        return null;

	}
		

}
