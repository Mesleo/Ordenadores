package ordenadores;

/**
 * Clase que crea ordenadores de sobremesa con los atributos de la clase padre m�s:
 * <ul>
 * 	<li>Rat�n y teclado</li>
 * </ul>
 * 
 * @author Javier Ben�tez del Pozo
 *
 */
public class Sobremesa extends Ordenador implements Precio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Booleano de raton teclado, est� a false de inicio
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
	 * @param numSerie N�mero de serie
	 * @param pantalla Tama�o de pantalla
	 * @param precio Precio del ordenador
	 * @param marca Marca de ordenador
	 * @param modelo Modelo de ordenador
	 * @param rt Rat�n y teclado
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
	 * Constructor PropioPC con n�mero de serie para buscarlo por dicho atributo
	 * 
	 * @param numSerie N�mero de serie del ordenador
	 */
	public Sobremesa(String numSerie) {
		super(numSerie);
	}

	/**
	 * Instancia un Sobremesa en caso de que todos los par�metros sean v�lidos, null si alguno no lo es
	 * 
	 * @param tipo Tipo de ordenador, SOBREMESA
	 * @param numSerie
	 *            Representa el n�mero de serie del nuevo ordenador
	 * @param pantalla
	 *            Representa la pantalla del nuevo ordenador
	 * @param precio Precio del ordenador
	 * @param marca Marca del ordenador
	 * @param modelo Modelo del ordenador
	 * @param rt Rat�n y teclado para el ordenador
	 * @return new Sobremesa si los par�metros son v�lidos, null si no lo son
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
	 * @param raton_teclado Rat�n y teclado para el ordenador sobremesa
	 * @return precio Del rat�n y teclado
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
				+ "\n\tN�mero de serie: " + numSerie + "\n\tPantalla: "
				+ pantalla + "\n\tMarca: " + marca + "\n\tModelo: " + modelo
				+ "\n\tRat�n y teclado: " + raton_teclado;
	}

	@Override
	public float calcularPrecio() {
		precio = precioPantalla(pantalla) + precioModelo(modelo)
				+ precioRatonTeclado(raton_teclado);
		return (float) (Math.rint(precio*1000)/1000);
	}

}
