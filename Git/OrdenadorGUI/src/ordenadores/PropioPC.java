package ordenadores;

public class PropioPC extends Ordenador implements Precio {

	private Componentes placa;
	private Componentes procesador;
	private Componentes ram;
	private Componentes discoDuro;
	private Componentes tarjetaGrafica;
	private Componentes fuenteAlimentacion;
	private float rate;
	private float tgraf;
	private float dduro;
	private float proc;
	private float ra;
	private float falim;
	private float plac;
	
	/**
	 * Constructor de PropioPC
	 * 
	 * @param tipo
	 * @param numSerie
	 * @param pantalla
	 * @param placa
	 * @param procesador
	 * @param ram
	 * @param discoDuro
	 * @param tarjetaGrafica
	 * @param fuenteAlimentacion
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

	public PropioPC(String numSerie) {
		super(numSerie);
	}

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
	 * @param placa
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
	 * @param procesador
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
	 * @param ram
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
	 * @param discoDuro
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
	 * @param tarjetaGrafica
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
	 * @param fuenteAlimentacion
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
	 * @param raton_teclado
	 * @return precio del ratón y teclado
	 */
	public float precioRatonTeclado(boolean raton_teclado) {
		if (raton_teclado == false)
			return 0;
		return 40f;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nPropioPC:\t\n\tFecha compra: " + fechaCompra
				+ "\n\tNúmero de serie: " + numSerie
				+ "\n\tPantalla: " + pantalla + 
				"\n\tPlaca=" + placa + "\n\tProcesador=" + procesador
				+ "\n\tRam=" + ram + "\n\tDiscoDuro=" + discoDuro
				+ "\n\tTarjetaGrafica=" + tarjetaGrafica
				+ "\n\tFuenteAlimentacion=" + fuenteAlimentacion;
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
