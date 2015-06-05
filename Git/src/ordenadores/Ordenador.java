/**
 * 
 */
package ordenadores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * Un ordenador tendr� las siguientes caracter�sticas:
 * <ul>
 * <li>N�mero de serie: Un�voco, consiste en 5 car�cteres alfanum�ricos</li>
 * <li>Pantalla: Tama�o de la pantalla en pulgadas</li>
 * <li>Fecha de compra: Generada autom�ticamente por el sistema, no hay que introducirla</li>
 * <li>Marca de ordenador, si se elige crear propio ordenador tendr� otras opciones m�s:
 * 	<ul>
 * 		<li>Placa base</li>
 * 		<li>Procesador</li>
 * 		<li>Ram</li>
 * 		<li>Disco duro</li>
 * 		<li>Tarjeta gr�fica</li>
 * 		<li>Fuente de alimentaci�n</li>
 * 	</ul></li>
 * <li>Modelo de ordenador, en el caso de propio PC esta opci�n no estar� disponible</li>
 * </ul>
 * 
 * @author Javier Ben�tez del Pozo
 * 
 * @version 1.0
 */
public abstract class Ordenador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * N�mero de serie de los ordenadores
	 */
	protected String numSerie;

	/**
	 * Tama�o de la pantalla
	 */
	protected Pantalla pantalla;

	/**
	 * Marca de ordenador
	 */
	protected MarcasOrdenador marca;

	/**
	 * Modelo de ordenador
	 */
	protected ModelosOrdenador modelo;

	/**
	 * Tipo de ordenador
	 */
	protected TipoOrdenador tipo;

	/**
	 * Rat�n y teclado
	 */
	protected boolean raton_teclado;

	/**
	 * Rat�n
	 */
	protected boolean raton;

	/**
	 * Malet�n
	 */
	protected boolean maletin;

	/**
	 * Precio del ordenador
	 */
	protected float precio;

	/**
	 * Fecha y hora actual metida en un String
	 */
	private Calendar calendario = GregorianCalendar.getInstance();
	private Date fecha = calendario.getTime();
	private SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
	protected String fechaCompra = formatoDeFecha.format(fecha);

	/**
	 * Variable de tipo String vac�a para poder instanciar objetos Ordenador
	 * para buscar por fecha
	 */
	static String s = "";

	/**
	 * Patr�n para un n�mero de serie v�lido
	 */
	static final protected Pattern patternNumSerie = Pattern
			.compile("^(\\w){5}$");
	
	Ordenador ordenador;

	/**
	 * Construye un nuevo coche con la fecha actual, un n�mero de serie y
	 * pantalla
	 * 
	 * @param tipo Tipo de ordenador
	 * @param numSerie
	 *            Representa el n�mero de serie del nuevo ordenador
	 * @param pantalla
	 *            Representa la pantalla del nuevo ordenador
	 * @param precio Precio del ordenador
	 */
	Ordenador(TipoOrdenador tipo, String numSerie, Pantalla pantalla,
			float precio) {
		setFechaCompra(fechaCompra);
		this.tipo = tipo;
		this.numSerie = numSerie;
		setPantalla(pantalla);
	}

	/**
	 * Construye un nuevo ordenador de numero de seire especificado
	 * 
	 * @param numSerie
	 *            Representa el numero de serie del nuevo ordenador
	 */
	public Ordenador(String numSerie) {
		setNumSerie(numSerie);
	}

	/**
	 * Construye un nuevo ordenador con una fecha especificada
	 * @param fechaCompra fecha de compra del ordenador
	 * @param s Cadena vac�a
	 */
	Ordenador(String fechaCompra, String s) {
		setFechaCompra(fechaCompra);
		Ordenador.s = "";
	}


	/**
	 * Comprueba si la matr�cula del coche es v�lida o no
	 * 
	 * @param numSerie
	 *            Representa el n�mero de serie a validar
	 * @return true si el n�mero de serie es v�lido, false si el n�mero de serie
	 *         no es v�lido
	 */
	public static boolean esValido(String numSerie) {
		return patternNumSerie.matcher(numSerie).matches();
	}

	/**
	 * @return the fechaCompra
	 */
	public String getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechacompra
	 *            the fechaCompra to set
	 */
	public void setFechaCompra(String fechacompra) {
		this.fechaCompra = fechacompra;
	}

	/**
	 * Modifica el numero de serie del ordenador
	 * 
	 * @param numSerie
	 *            Representa el numero de serie del nuevo ordenador
	 */
	private void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * 
	 * @return N�mero de serie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * Modifica el tama�o de la pantalla
	 * 
	 * @param pantalla
	 *            Representa el nuevo tama�o de la pantalla
	 */
	private void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	/**
	 * Devuelve el tama�o de la pantalla
	 * 
	 * @return Tama�o de la pantalla
	 */
	public Pantalla getPantalla() {
		return pantalla;
	}

	/**
	 * 
	 * @param pantalla del ordenador
	 * @return precio de la pantalla
	 */
	public float precioPantalla(Pantalla pantalla) {
		if (pantalla == null)
			return 0;
		return pantalla.getPrecio();

	}

	/**
	 * @return the marca
	 */
	public MarcasOrdenador getMarca() {
		return marca;
	}

	/**
	 * @return the modelo
	 */
	public ModelosOrdenador getModelo() {
		return modelo;
	}

	/**
	 * 
	 * @param modelo de ordenador
	 * @return precio del modelo de ordenador
	 */
	public float precioModelo(ModelosOrdenador modelo) {
		if (modelo == null)
			return 0;
		return modelo.getPrecio();
	}

	/**
	 * 
	 * @return tipo de ordenador
	 */
	public TipoOrdenador getTipo() {
		return tipo;
	}

	/**
	 * HasCode de la fechaCompra y numSerie
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result
				+ ((numSerie == null) ? 0 : numSerie.hashCode());
		return result;
	}

	/**
	 * Compara el n�mero de serie de un objeto pasado por par�metro con los existentes en el arrayList
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordenador other = (Ordenador) obj;
		if (numSerie == null) {
			if (other.numSerie != null)
				return false;
		} else if (!numSerie.equals(other.numSerie))
			return false;
		return true;
	}

}