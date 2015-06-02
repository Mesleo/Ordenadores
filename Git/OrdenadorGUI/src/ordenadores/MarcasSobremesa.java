/**
 * 
 */
package ordenadores;

/**
 * Representa cada una de las marcas
 * 
 * @author Javier Benítez del Pozo
 * @version 1.0
 */
public enum MarcasSobremesa {
	
	/**
	 * Representa la marca ASUS
	 */
	ASUS, 
	
	/**
	 * Representa la marca SONYVAIO
	 */
	SONYVAIO,
	
	/**
	 * Representa la marca APPLE
	 */
	APPLE, 
	
	/**
	 * Representa la marca CREAR_MI_PROPIO_ORDENADOR
	 */
	CREAR_MI_PROPIO_ORDENADOR;
	

	/**
	 * Construye una nueva marca
	 * 
	 */
	MarcasSobremesa() {
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name();

	}

	// Para el menú-------------------------------------------------
	
	/**
	 * Array de modelos
	 */
	private static final MarcasSobremesa[] VALUES = MarcasSobremesa.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del menú
	 * 
	 * @return Array de cadenas con las opciones del menú
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (MarcasSobremesa modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de modelos
	 * 
	 * @return Array de modelos
	 */
	public static MarcasSobremesa[] getValues() {
		return VALUES;
	}


}