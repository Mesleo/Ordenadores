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
 * <li></li>
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
	protected static String numSerie;
	
	/**
	 * Tama�o de la pantalla
	 */
	protected static Pantalla pantalla;
	
	/**
	 * Fecha y hora actual metida en un String
	 */
	static Calendar calendario = GregorianCalendar.getInstance();
	static Date fecha = calendario.getTime();
	static SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
	static String fechaActual = formatoDeFecha.format(fecha);
	
	static String s = "";


	/**
	 * Patr�n para un n�mero de serie v�lido
	 */
	static final protected Pattern patternNumSerie = Pattern
			.compile("^(\\w){10}$");

	/**
	 * Construye un nuevo coche con la fecha actual, un n�mero de serie y pantalla
	 * 
	 * @param numSerie
	 *            Representa el n�mero de serie del nuevo ordenador
	 * @param pantalla
	 *            Representa la pantalla del nuevo ordenador
	 */
	protected Ordenador(String numSerie, Pantalla pantalla){
		setFechaActual(fechaActual);
		setNumSerie(numSerie);
		setPantalla(pantalla);
	}
	

	/**
	 * Construye un nuevo ordenador de numero de seire especificado
	 * 
	 * @param numSerie
	 *            Representa el numero de serie del nuevo ordenador
	 */
	protected Ordenador(String numSerie) {
		setNumSerie(numSerie);
	}
	
	/**
	 * Construye un nuevo ordenador de numero de seire especificado
	 * 
	 * @param numSerie
	 *            Representa el numero de serie del nuevo ordenador
	 */
	Ordenador(String fechaActual, String s) {
		setFechaActual(fechaActual);
		Ordenador.s = "";
	}


	public abstract float calcularPrecio();
	
	/**
	 * Comprueba si la matr�cula del coche es v�lida o no
	 * 
	 * @param numSerie
	 *            Representa el n�mero de serie a validar
	 * @return true si el n�mero de serie es v�lido, false si el n�mero de serie no es
	 *         v�lido
	 */
	public static boolean esValido(String numSerie) {
		return patternNumSerie.matcher(numSerie).matches();
	}


	/**
	 * @return the fechaActual
	 */
	public String getFechaActual() {
		return fechaActual;
	}

	/**
	 * @param fechaActual the fechaActual to set
	 */
	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

	/**
	 * Modifica el numero de serie  del ordenador
	 * 
	 * @param numSerie
	 *            Representa el numero de serie del nuevo ordenador
	 */
	private void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
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
	 * @return
	 * 			N�mero de serie
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


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numSerie == null) ? 0 : numSerie.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
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
		if (fechaActual == null)
			return false;
		if (numSerie == null) {
			if (other.numSerie != null)
				return false;
		} else if (!numSerie.equals(other.numSerie))
			return false;
		return true;
	}

}