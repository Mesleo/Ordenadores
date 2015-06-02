/**
 * 
 */
package ordenadores;

/**
 * Se limitar�n las pantallas a 4 tama�os: 11, 15, 21 y 27. Para solicitar el tama�o
 * al comprar un ordenador podr� implementarse un m�todo pedirPantalla que mediante
 * la gesti�n de un men�, devolver� la pantalla indicada.
 * 
 * @author Javier Ben�tez del Pozo
 * @version 1.0
 */
public enum Pantalla {
	
	/**
	 * Representa el tama�o 11
	 */
	ONCE("11 pulgadas", 45.00f), 
	
	/**
	 * Representa el tama�o 15
	 */
	QUINCE("15 pulgadasS", 99.00f), 
	
	/**
	 * Representa el tama�o 21
	 */
	VEINTIUNA("21 pulgadas", 130.00f),

	/**
	 * Representa el tama�o 27
	 */
	VEINTISIETE("27 pulgadas", 190.00f);
	
	
	/**
	 * Crea una nueva pantalla de las pulgadas indicadas con un precio establecido
	 * @param pulgadas
	 * @param precio
	 */
	Pantalla(String pulgadas, float precio){
		this.setPulgadas(pulgadas);
		this.precio = precio;
	}
	
	
	private String pulgadas;
	
	private float precio;

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Array de colores
	 */
	private static final Pantalla[] VALUES = Pantalla.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del men�
	 * 
	 * @return Array de cadenas con las opciones del men�
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Pantalla pantalla : getValues()) {
			opcionesMenu[i++] = pantalla.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de colores
	 * 
	 * @return Array de colores
	 */
	public static Pantalla[] getValues() {
		return VALUES;
	}

	public String getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(String pulgadas) {
		this.pulgadas = pulgadas;
	}

}