package ordenadores;

/**
 * Clase que crea port�tiles con los atributos de la clase padre m�s:
 * <ul>
 * 	<li>Rat�n</li>
 * <li>Malet�n</li>
 * </ul>
 * 
 * @author Javier Ben�tez del Pozo
 *
 */
public class Portatil extends Ordenador implements Precio {

	/**
	 * Booleano de rat�n, por defecto a false
	 */
	private boolean raton;

	/**
	 * Booleano de malet�n, por defecto a false
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
	 * Contructor de Ordenador Port�til
	 * 
	 * @param tipo Tipo de ordenador, PORTATIL
	 * @param numSerie N�mero de serie, un�voco
	 * @param pantalla Tama�o de pantalla
	 * @param precio Precio del ordenador
	 * @param marca Marca de ordenador
	 * @param modelo Modelo de ordenador
	 * @param raton Rat�n para el port�til
	 * @param maletin Malet�n para el port�til
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
	 * Instancia un new Portatil si los par�metros son v�lidos
	 * 
	  * @param tipo Tipo de ordenador, PORTATIL
	 * @param numSerie
	 *            Representa el n�mero de serie del nuevo ordenador
	 * @param pantalla
	 *            Representa la pantalla del nuevo ordenador
	 * @param precio Precio del ordenador
	 * @param marca Marca del ordenador
	 * @param modelo Modelo del ordenador
	 * @param raton Rat�n para el port�til
	 * @param maletin Malet�n del port�til
	 * @return new Portatil si  los par�metros son v�lidos, null si no lo son
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
	 * @param raton Rat�n para el Port�til
	 * @return precio del rat�n
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
	 * @param maletin Malet�n para el port�til
	 * @return precio del malet�n
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
				+ "\n\tN�mero de serie: " + numSerie
				+ "\n\tPantalla: " + pantalla
				+ "\n\tMarca: " + marca
				+ "\n\tModelo: " + modelo
				+ "\n\tRat�n y teclado: " + raton 
				+ "\n\tMalet�n: " + maletin ;
	}

	/**
	 * M�todo abstracto que implementa la interfaz Precio
	 * 
	 */
	@Override
	public float calcularPrecio() {
		precio = precioPantalla(pantalla)+precioModelo(modelo)+precioRaton(raton)+precioMaletin(maletin);
		return (float) (Math.rint(precio*1000)/1000);
	}

	
}
