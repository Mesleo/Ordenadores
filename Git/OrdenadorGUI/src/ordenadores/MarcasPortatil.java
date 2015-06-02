package ordenadores;

public enum MarcasPortatil {

	ASUS,
	
	TOSHIBA,
	
	SONYVAIO,
	
	APPLE;
	
	/**
	 * Contruye una nueva marca de port�til
	 */
	MarcasPortatil() {
		// TODO Auto-generated constructor stub
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

	// Para el men�-------------------------------------------------
	
	/**
	 * Array de modelos
	 */
	private static final MarcasPortatil[] VALUES = MarcasPortatil.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del men�
	 * 
	 * @return Array de cadenas con las opciones del men�
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (MarcasPortatil marcaportatil : VALUES) {
			opcionesMenu[i++] = marcaportatil.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de modelos
	 * 
	 * @return Array de modelos
	 */
	public static MarcasPortatil[] getValues() {
		return VALUES;
	}
	
}
