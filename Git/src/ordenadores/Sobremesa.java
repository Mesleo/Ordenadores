package ordenadores;

/**
 * Clase que crea ordenadores de sobremesa con los atributos de la clase padre más:
 * <ul>
 * 	<li>Ratón y teclado</li>
 * </ul>
 * 
 * @author Javier Benítez del Pozo
 *
 */
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
	 * @param tipo Tipo de ordenador
	 * @param numSerie Número de serie
	 * @param pantalla Tamaño de pantalla
	 * @param precio Precio del ordenador
	 * @param marca Marca de ordenador
	 * @param modelo Modelo de ordenador
	 * @param rt Ratón y teclado
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

	/**
	 * Constructor PropioPC con número de serie para buscarlo por dicho atributo
	 * 
	 * @param numSerie Número de serie del ordenador
	 */
	public Sobremesa(String numSerie) {
		super(numSerie);
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
	 * @param marca Marca del ordenador
	 * @param modelo Modelo del ordenador
	 * @param rt Ratón y teclado para el ordenador
	 * @return new Sobremesa si los parámetros son válidos, null si no lo son
	 */
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
	 * @param raton_teclado Ratón y teclado para el ordenador sobremesa
	 * @return precio Del ratón y teclado
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
