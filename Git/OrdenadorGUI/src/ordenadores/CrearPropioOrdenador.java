package ordenadores;

public enum CrearPropioOrdenador {

	/**
	 * Representa la placa base
	 */
	PLACABASE(MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR),
	
	/**
	 * Representa el procesador
	 */
	PROCESADOR(MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR),
	
	/**
	 * Representa la memoria RAM
	 */
	RAM(MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR),
	
	/**
	 * Representa el disco duro
	 */
	DISCODURO(MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR),
	
	/**
	 * Representa la tarjeta gráfica
	 */
	TARJETAGRAFICA(MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR),
	
	/**
	 * Representa la fuente de alimentación
	 */
	FUENTEALIMENTACION(MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR);
	
	private MarcasOrdenador marcaordenador;
	
	
	private CrearPropioOrdenador(MarcasOrdenador marcaordenador) {
		this.marcaordenador = marcaordenador;
	}
	
}
