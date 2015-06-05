package ordenadores;

/**
 * Clase que crea ordenadores por componentes con los atributos de la clase padre más:
 * <ul>
 * 	<li>Ratón y teclado</li>
 * </ul> 
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class PropioPC extends Ordenador implements Precio {

	private Componentes placa;
	private Componentes procesador;
	private Componentes ram;
	private Componentes discoDuro;
	private Componentes tarjetaGrafica;
	private Componentes fuenteAlimentacion;
	
	/**
	 * Constructor de PropioPC
	 * 
	 * @param tipo Tipo de ordenador
	 * @param numSerie Número de serie del ordenador
	 * @param pantalla Tamaño de la pantalla
	 * @param precio Precio del ordenador
	 * @param marca Marca de propioPC, siempre sera el elemento CREAR_MI_PROPIO_ORDENADOR
	 * @param placa Placa base
	 * @param procesador Procesador
	 * @param ram Memoria RAM
	 * @param discoDuro Disco duro
	 * @param tarjetaGrafica Tarjeta grafica
	 * @param fuenteAlimentacion Fuente de alimentación
	 * @param rt Ratón y teclado para PropioPC
	 */
	public PropioPC(TipoOrdenador tipo, String numSerie, Pantalla pantalla, float precio, MarcasOrdenador marca, Componentes placa,
			Componentes procesador, Componentes ram, Componentes discoDuro, Componentes tarjetaGrafica,
			Componentes fuenteAlimentacion, boolean rt) {
		super(tipo, numSerie, pantalla, precio);
		this.marca = marca;
		setPlaca(placa);
		setProcesador(procesador);
		setRam(ram);
		setDiscoDuro(discoDuro);
		setTarjetaGrafica(tarjetaGrafica);
		setFuenteAlimentacion(fuenteAlimentacion);
		this.raton_teclado = rt;
	}

	/**
	 * Instancia un Sobremesa en caso de que todos los parámetros sean válidos, null si alguno no lo es
	 * 
	 * @param tipo Tipo de ordenador, SOBREMESA
	 * @param numSerie
	 *            Representa el número de serie del nuevo ordenador
	 * @param pantalla
	 *            Representa la pantalla del nuevo ordenador
	 * @param precio Precio del ordenador
	 * @param marca Marca del ordenador, CREAR_MI_PROPIO_ORDENADOR
	 * @param placa Placa base del ordenador
	 * @param procesador Procesador del ordenador
	 * @param ram Memoria RAM del ordenador
	 * @param discoDuro Disco duro del ordenador
	 * @param tarjetaGrafica Tarjeta gráfica para el ordenador
	 * @param fuenteAlimentacion Fuente de alimentación para el ordenador
	 * @param raton_teclado Ratón y teclado para el ordenador
	 * @return new PropioPC si los parámetros son válidos, null si no lo son
	 */
	public static Ordenador instanciarOrdenador(TipoOrdenador tipo,
			String numSerie, Pantalla pantalla, float precio, MarcasOrdenador marca, Componentes placa,
			Componentes procesador, Componentes ram, Componentes discoDuro,
			Componentes tarjetaGrafica, Componentes fuenteAlimentacion, boolean raton_teclado) {
		if (esValido(numSerie)){
			return (Ordenador)new PropioPC(tipo, numSerie, pantalla, precio, marca, placa, procesador, ram, discoDuro,
					tarjetaGrafica, fuenteAlimentacion, raton_teclado);
		}else
			return null;
	}
	
	/**
	 * Constructor PropioPC con número de serie para buscarlo por dicho atributo
	 * 
	 * @param numSerie Número de serie del ordenador
	 */
	public PropioPC(String numSerie) {
		super(numSerie);
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return the placa
	 */
	public Componentes getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(Componentes placa) {
		this.placa = placa;
	}
	
	/**
	 * 
	 * @param placa Placa base del ordenadorSS
	 * @return precio de la placa base
	 */
	public float precioPlaca(Componentes placa){
		return placa.getPrecio();
	}

	/**
	 * @return the procesador
	 */
	public Componentes getProcesador() {
		return procesador;
	}

	/**
	 * @param procesador the procesador to set
	 */
	public void setProcesador(Componentes procesador) {
		this.procesador = procesador;
	}
	
	/**
	 * 
	 * @param procesador Procesador para el ordenador
	 * @return precio del procesador
	 */
	public float precioProcesador(Componentes procesador){
		return procesador.getPrecio();
	}

	/**
	 * @return the ram
	 */
	public Componentes getRam() {
		return ram;
	}

	/**
	 * @param ram the ram to set
	 */
	public void setRam(Componentes ram) {
		this.ram = ram;
	}
	
	/**
	 * 
	 * @param ram Memoria RAM para el ordenador
	 * @return precio de la memoria ram
	 */
	public float precioRam(Componentes ram){
		return ram.getPrecio();
	}

	/**
	 * @return the discoDuro
	 */
	public Componentes getDiscoDuro() {
		return discoDuro;
	}

	/**
	 * @param discoDuro the discoDuro to set
	 */
	public void setDiscoDuro(Componentes discoDuro) {
		this.discoDuro = discoDuro;
	}

	/**
	 * 
	 * @param discoDuro Disco duro para el ordenador
	 * @return precio del disco duro
	 */
	public float precioDiscoDuro(Componentes discoDuro){
		return discoDuro.getPrecio();
	}
	
	/**
	 * @return the tarjetaGrafica
	 */
	public Componentes getTarjetaGrafica() {
		return tarjetaGrafica;
	}

	/**
	 * @param tarjetaGrafica the tarjetaGrafica to set
	 */
	public void setTarjetaGrafica(Componentes tarjetaGrafica) {
		this.tarjetaGrafica = tarjetaGrafica;
	}
	
	/**
	 * 
	 * @param tarjetaGrafica Tarjeta gráfica del ordenador
	 * @return precio de la tarjeta gráfica
	 */
	public float precioTarjetaGrafica(Componentes tarjetaGrafica){
		return tarjetaGrafica.getPrecio();
	}

	/**
	 * @return the fuenteAlimentacion
	 */
	public Componentes getFuenteAlimentacion() {
		return fuenteAlimentacion;
	}

	/**
	 * @param fuenteAlimentacion the fuenteAlimentacion to set
	 */
	public void setFuenteAlimentacion(Componentes fuenteAlimentacion) {
		this.fuenteAlimentacion = fuenteAlimentacion;
	}
	
	/**
	 * 
	 * @param fuenteAlimentacion Fuente de alimentación para el ordenador
	 * @return precio de la fuente de alimentación
	 */
	public float precioFuenteAlimentacion(Componentes fuenteAlimentacion){
		return fuenteAlimentacion.getPrecio();
	}
	
	/**
	 * @return the raton_teclado
	 */
	public boolean isRaton_teclado() {
		return raton_teclado;
	}

	public void setRaton_teclado(boolean raton_teclado) {
		this.raton_teclado = raton_teclado;
	}

	/**
	 * 
	 * @param raton_teclado Ratón y teclado del ordenador PropioPC
	 * @return precio del ratón y teclado
	 */
	public float precioRatonTeclado(boolean raton_teclado) {
		if (raton_teclado == false)
			return 0;
		return 40f;
	}

	public float calcularPrecio() {
		precio = precioPantalla(pantalla) + precioRatonTeclado(raton_teclado)
				+ precioPlaca(placa) + precioProcesador(procesador) +
				precioRam(ram) + precioDiscoDuro(discoDuro)+
				precioTarjetaGrafica(tarjetaGrafica)+
				precioFuenteAlimentacion(fuenteAlimentacion);
		return (float) (Math.rint(precio*1000)/1000);
	}

	
}
