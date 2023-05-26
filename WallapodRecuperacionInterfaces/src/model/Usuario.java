package model;

import java.util.Objects;

import interfaces.IUsuario;

public class Usuario implements IUsuario {
	
	private String nombre;//nombre del usuario

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Usuario() {
		super();
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
		
	}

	@Override
	public String getNombre() {
		
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "]";
	}

	

}
