/**
 * 
 */
package ordenadores;

/**
 * Se limitar�n los colores a tres: blanco, rojo y negro. Para solicitar el color
 * al dar de alta un ordenador podr� implementarse un m�todo pedirColor que mediante
 * la gesti�n de un men�, devolver� el color indicado.
 * 
 * @author Javier Ben�tez del Pozo
 * @version 1.0
 */
public enum Color {
	
	/**
	 * Representa el color blanco
	 */
	BLANCO, 
	
	/**
	 * Representa el color rojo
	 */
	ROJO, 
	
	/**
	 * Representa el color negro
	 */
	NEGRO;

	/**
	 * Array de colores
	 */
	private static final Color[] VALUES = Color.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del men�
	 * 
	 * @return Array de cadenas con las opciones del men�
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de colores
	 * 
	 * @return Array de colores
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}