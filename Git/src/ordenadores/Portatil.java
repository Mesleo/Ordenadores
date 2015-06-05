package ordenadores;

/**
 * Clase que crea portátiles con los atributos de la clase padre más:
 * <ul>
 * 	<li>Ratón</li>
 * <li>Maletín</li>
 * </ul>
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Portatil extends Ordenador implements Precio {

	/**
	 * Booleano de ratón, por defecto a false
	 */
	private boolean raton;

	/**
	 * Booleano de maletín, por defecto a false
	 */
	private boolean maletin;

	/**
	 * Marca de ordenador
	 */
	private MarcasOrdenador marca;

	/**
	 * Modelo de ordenador
	 */
	private ModelosOrdenador modelo;

	/**
	 * Contructor de Ordenador Portátil
	 * 
	 * @param tipo Tipo de ordenador, PORTATIL
	 * @param numSerie Número de serie, unívoco
	 * @param pantalla Tamaño de pantalla
	 * @param precio Precio del ordenador
	 * @param marca Marca de ordenador
	 * @param modelo Modelo de ordenador
	 * @param raton Ratón para el portátil
	 * @param maletin Maletín para el portátil
	 */
	public Portatil(TipoOrdenador tipo, String numSerie, Pantalla pantalla, float precio,
			MarcasOrdenador marca, ModelosOrdenador modelo, boolean raton,
			boolean maletin) {
		super(tipo, numSerie, pantalla, precio);
		this.marca = marca;
		this.modelo = modelo;
		setRaton(raton);
		setMaletin(maletin);
	}

	public Portatil(String numSerie) {
		super(numSerie);
	}

	/**
	 * Instancia un new Portatil si los parámetros son válidos
	 * 
	  * @param tipo Tipo de ordenador, PORTATIL
	 * @param numSerie
	 *            Representa el número de serie del nuevo ordenador
	 * @param pantalla
	 *            Representa la pantalla del nuevo ordenador
	 * @param precio Precio del ordenador
	 * @param marca Marca del ordenador
	 * @param modelo Modelo del ordenador
	 * @param raton Ratón para el portátil
	 * @param maletin Maletín del portátil
	 * @return new Portatil si  los parámetros son válidos, null si no lo son
	 */
	public static Portatil instanciarOrdenador(TipoOrdenador tipo,
			String numSerie, Pantalla pantalla, float precio, MarcasOrdenador marca,
			ModelosOrdenador modelo, boolean raton, boolean maletin) {
		if (esValido(numSerie)) {
			return new Portatil(tipo, numSerie,
					pantalla, precio, marca, modelo, raton, maletin);
		} else
			return null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MarcasOrdenador getMarcasportatil() {
		return marca;
	}

	public void setMarca(MarcasOrdenador marcasportatil) {
		this.marca = marcasportatil;
	}
	
	/**
	 * @return the modelo
	 */
	public ModelosOrdenador getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(ModelosOrdenador modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * @return the raton
	 */
	public boolean isRaton() {
		return raton;
	}

	public void setRaton(boolean raton) {
		this.raton = raton;
	}

	/**
	 * 
	 * @param raton Ratón para el Portátil
	 * @return precio del ratón
	 */
	public float precioRaton(boolean raton) {
		if (raton == false)
			return 0;
		return 15f;
	}

	/**
	 * @return the maletin
	 */
	public boolean isMaletin() {
		return maletin;
	}

	public void setMaletin(boolean maletin) {
		this.maletin = maletin;
	}

	/**
	 * @param maletin Maletín para el portátil
	 * @return precio del maletín
	 */
	public float precioMaletin(boolean maletin) {
		if (maletin == false)
			return 0;
		return 25f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nPortatil:\t\n\tFecha compra: " + fechaCompra
				+ "\n\tNúmero de serie: " + numSerie
				+ "\n\tPantalla: " + pantalla
				+ "\n\tMarca: " + marca
				+ "\n\tModelo: " + modelo
				+ "\n\tRatón y teclado: " + raton 
				+ "\n\tMaletín: " + maletin ;
	}

	/**
	 * Método abstracto que implementa la interfaz Precio
	 * 
	 */
	@Override
	public float calcularPrecio() {
		precio = precioPantalla(pantalla)+precioModelo(modelo)+precioRaton(raton)+precioMaletin(maletin);
		return (float) (Math.rint(precio*1000)/1000);
	}

	
}
