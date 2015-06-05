/**
 * 
 */
package ordenadores;

import java.util.ArrayList;

/**
 * Representa cada una de las marcas de los ordenadores
 * 
 * @author Javier Benítez del Pozo
 * @version 1.0
 */
public enum MarcasOrdenador {
	
	/**
	 * Representa la marca ASUS
	 */
	ASUS(TipoOrdenador.SOBREMESA), 
	
	/**
	 * Representa la marca SONYVAIO
	 */
	SONYVAIO(TipoOrdenador.SOBREMESA),
	
	/**
	 * Representa la marca APPLE
	 */
	APPLE(TipoOrdenador.SOBREMESA), 
	
	/**
	 * Representa la marca CREAR_MI_PROPIO_ORDENADOR
	 */
	CREAR_MI_PROPIO_ORDENADOR(TipoOrdenador.SOBREMESA),
	
	/**
	 * Representa la marca ASUS_PORTATIL
	 */
	ASUS_PORTATIL(TipoOrdenador.PORTATIL),
	
	/**
	 * Representa la marca TOSHIBA
	 */
	TOSHIBA(TipoOrdenador.PORTATIL),
	
	/**
	 * Representa la marca SONYVAIO_PORTATIL
	 */
	SONYVAIO_PORTATIL(TipoOrdenador.PORTATIL),
	
	/**
	 * Representa la marca APPLE_PORTATIL
	 */
	APPLE_PORTATIL(TipoOrdenador.PORTATIL);
	

	private TipoOrdenador clase;
	
	/**
	 * Construye una nueva marca
	 * 
	 */
	MarcasOrdenador(TipoOrdenador clase) {
		this.setTipo(clase);
	}

	public static Object[] getArray(TipoOrdenador clase){
		ArrayList<MarcasOrdenador> arrayList = new ArrayList<MarcasOrdenador>();
		for (MarcasOrdenador marcaordenador : values()) {
			if(marcaordenador.clase == clase) 
				arrayList.add(marcaordenador);
		}
		return arrayList.toArray();
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
	private static final MarcasOrdenador[] VALUES = MarcasOrdenador.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del menú
	 * 
	 * @return Array de cadenas con las opciones del menú
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (MarcasOrdenador modelo : VALUES) {
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
	public static MarcasOrdenador[] getValues() {
		return VALUES;
	}


	public TipoOrdenador getTipo() {
		return clase;
	}


	public void setTipo(TipoOrdenador clase2) {
		this.clase = clase2;
	}


//	public MarcasOrdenadores getMarca() {
////		return marcas;
//	}


}