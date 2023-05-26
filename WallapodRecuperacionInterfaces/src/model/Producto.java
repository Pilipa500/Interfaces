package model;

import java.util.Objects;

import interfaces.IProducto;
import interfaces.IUsuario;

public class Producto implements IProducto, Comparable<IProducto> {
	
	

    private String nombre;
    private double precio;
    private IUsuario usuario;
    private boolean caducado;

    public Producto(String nombre, double precio, IUsuario usuario) {
        this.nombre = nombre;
        this.precio = precio;
        this.usuario = usuario;
        this.caducado = false;
    }
    

    public Producto() {
		this.nombre="";
		this.precio=0;
		this.usuario=null;
		
	}


	@Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setUsuario(IUsuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public IUsuario getUsuario() {
        return usuario;
    }

    @Override
    public void setCaducado(boolean caducado) {
        this.caducado = caducado;
    }

    @Override
    public boolean getCaducado() {
        return caducado;
    }

    @Override
    public int compareTo(IProducto otroProducto) {
        return Double.compare(this.precio, otroProducto.getPrecio());
    }

	@Override
	public int hashCode() {
		return Objects.hash(caducado, nombre, precio, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return caducado == other.caducado && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", usuario=" + usuario + ", caducado=" + caducado
				+ "]";
	}
    
}


