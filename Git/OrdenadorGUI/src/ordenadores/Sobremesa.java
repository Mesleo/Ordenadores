package ordenadores;

public class Sobremesa extends Ordenador implements Precio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Booleano de raton teclado, está a false de inicio
	 */
	private boolean raton_teclado;

	/**
	 * Marca de ordenador
	 */
	private MarcasOrdenador marca;

	/**
	 * Modelo de ordenador
	 */
	private ModelosOrdenador modelo;

	/**
	 * Constructor de Ordenador de Sobremesa
	 * 
	 * @param tipo
	 * @param numSerie
	 * @param pantalla
	 * @param marca
	 * @param modelo
	 * @param rt
	 */
	public Sobremesa(TipoOrdenador tipo, String numSerie, Pantalla pantalla,
			float precio, MarcasOrdenador marca, ModelosOrdenador modelo,
			boolean rt) {
		super(tipo, numSerie, pantalla, precio);
		this.precio = calcularPrecio();
		this.marca = marca;
		this.modelo = modelo;
		setRaton_teclado(rt);
	}

	public Sobremesa(String numSerie) {
		super(numSerie);
	}


	public static Ordenador instanciarOrdenador(TipoOrdenador tipo, String numSerie,
			Pantalla pantalla, float precio, MarcasOrdenador marca,
			ModelosOrdenador modelo, boolean rt) {
		if (esValido(numSerie))
			return (Ordenador)new Sobremesa(tipo, numSerie, pantalla, precio,
					marca, modelo, rt);
		return null;
	}

	/**
	 * @return the marcasobremesa
	 */
	public MarcasOrdenador getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marcasobremesa to set
	 */
	public void setMarca(MarcasOrdenador marca) {
		this.marca = marca;
	}

	public ModelosOrdenador getModelo() {
		return modelo;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Representa el nuevo modelo del coche
	 */
	public void setModelo(ModelosOrdenador modelo) {
		this.modelo = modelo;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nSobremesa:\t\n\tFecha compra: " + fechaCompra
				+ "\n\tNúmero de serie: " + numSerie + "\n\tPantalla: "
				+ pantalla + "\n\tMarca: " + marca + "\n\tModelo: " + modelo
				+ "\n\tRatón y teclado: " + raton_teclado;
	}

	@Override
	public float calcularPrecio() {
		precio = precioPantalla(pantalla) + precioModelo(modelo)
				+ precioRatonTeclado(raton_teclado);
		return (float) (Math.rint(precio*1000)/1000);
	}

}
