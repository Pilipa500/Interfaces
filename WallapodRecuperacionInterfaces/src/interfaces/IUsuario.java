package interfaces;

/**
 * Interfaz que modela el comportamiento de un Usuario.
 * Se considera que dos Usuarios son iguales si tienen el mismo nombre
 * 
 * @author Raul SG
 *
 */
public interface IUsuario {

	/**
	 * Metodo utilizado para modificar el nombre de un usuario. 
	 * 
	 * @param nombre. El nombre pasado por parametro sera el nuevo nombre
	 * 
	 * El nombre nunca va a ser null.
	 */
	public void setNombre(String nombre);
	
	/**
	 * Metodo que devuelve el nombre del usuario.
	 * 
	 * @return String. Cadena que contiene el nombre del usuario
	 */
	public String getNombre();
}
