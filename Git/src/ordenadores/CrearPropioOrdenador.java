package ordenadores;

/**
 * Aquí están las distintas piezas con las que se puede montar un ordenador por piezas:
 * 
 * <ul>
 * 	<li>Placa base</li>
 * <li>Procesador</li>
 * <li>RAM</li>
 * <li>Disco duro</li>
 * <li>Tarjeta gráfica</li>
 * <li>Fuente alimentación</li>
 * </ul>
 * 
 * @author Javier Benítez del Pozo
 *
 */
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
		this.setMarcaordenador(marcaordenador);
	}


	public MarcasOrdenador getMarcaordenador() {
		return marcaordenador;
	}


	public void setMarcaordenador(MarcasOrdenador marcaordenador) {
		this.marcaordenador = marcaordenador;
	}
	
}
