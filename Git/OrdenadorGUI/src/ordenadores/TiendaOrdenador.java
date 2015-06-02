/**
 * Paquete ordendadores
 */
package ordenadores;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Queremos modelar una tienda de ordenadores en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>Compra de un ordenador(se pedir� n�mero de serie, tama�o de pantalla, etc. 
 * Esto variar� en funci�n de el tipo de ordenador).</li>
 * <li>Venta de un ordenador (por n�mero de serie).</li>
 * <li>Mostrar un ordenador (por n�mero de serie).</li>
 * <li>Mostrar almac�n (todos los ordenadores de la tienda, port�tiles o sobremesa).</li>
 * <li>Contar el n�mero de ordenadores en la tienda.</li>
 * <li>Mostrar ordenadores por fecha de compra.</li>
 * </ol>
 * L�gicamente, no podr� a�adirse un ordenador inv�lido o ya contenido (no pueden
 * existir dos ordenadores con el mismo n�mero de serie en el almac�n). Por cada
 * ordenador que se compre, han de conocerse todas sus caracter�sticas. Ninguna
 * de las caracter�sticas del ordenador puede ser por defecto.
 * 
 * @author Javier Benitez del Pozo
 * @version 1.0
 */
public class TiendaOrdenador implements Serializable{
	
	/**
	 * Colecci�n de ordenadores. No puede tener null.
	 */
	private ArrayList<Ordenador> almacen = new ArrayList<Ordenador>();
	
	/**
	 * Nombre del almacen
	 */
	private final String nombre = "Inform�tica Ben�tez";

	/**
	 * A�ade un coche al almacen
	 * 
	 * @param numSerie
	 *            Representa la matr�cula del ordenador a a�adir
	 * @param pantalla
	 *            Representa la pantalla del ordenador a a�adir
	 * @param modelo
	 *            Representa el modelo del ordenador a a�adir
	 * @return true si el ordenador se a�ade, false en otro caso (el ordenador es null o
	 *         el ordenador ya est� contenido en el almacen)
	 */
	/**
	 * @param formatoFecha
	 * @param numSerie
	 * @param pantalla
	 * @param modelo
	 * @return
	 */
	public boolean annadirOrdenador(String numSerie, Pantalla pantalla, boolean ratonteclado, MarcasSobremesa marca,  ModelosSobremesa modelo) {
		Ordenador sobremesa = Sobremesa.instanciarSobremesa(numSerie, pantalla, ratonteclado, marca, modelo);
		if (sobremesa == null || almacen.contains(sobremesa))
			return false;
		return almacen.add(sobremesa);
	}

	/**
	 * Elimina un ordenador del almacen
	 * 
	 * @param numSerie
	 *            Representa el n�mero de serie del ordenador a eliminar
	 * @return true si el ordenador se elimina, false en otro caso (el ordenador no est�
	 *         en el almacen)
	 */
	public boolean eliminar(String numSerie) {
		return almacen.remove(Sobremesa.instanciarOrdenador(numSerie));
	}

	/**
	 * Devuelve el n�mero de ordenadores del almacen
	 * 
	 * @return N�mero de ordenadores del almacen
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el ordenador indicado por el n�mero de serie
	 * 
	 * @param numSerie
	 *            Representa el n�mero de serie a buscar
	 * @return Ordenador contenido en el almacen. null si no existe
	 */
	public Ordenador get(String numSerie) {
		Ordenador ordendador = Sobremesa.instanciarOrdenador(numSerie);
		int index = almacen.indexOf(ordendador);
		if (index != -1) {
			return (Ordenador) almacen.get(index);
		}
		return null;
	}
	
	public Ordenador get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return (Ordenador) almacen.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tienda ordendores " + nombre + "[almacen=" + almacen + "]";
	}

	/**
	 * Genera una lista de ordenadores de una determinada fecha
	 * 
	 * @param fechaCompra
	 *            Representa la fecha de compra de un ordenador
	 * @param string 
	 * @return Lista de ordenadores de una determinada fecha
	 */
	public ArrayList<Ordenador> getOrdenadoresFecha(String fechaCompra) {
		ArrayList<Ordenador> arrOrdenadoresFecha = new ArrayList<Ordenador>();
		for (Ordenador ordenador : almacen) {
			System.out.println("Ordenador: " + ordenador);
			System.out.println("Antes del if. Array: " + arrOrdenadoresFecha);
			if(ordenador.getFechaActual() == fechaCompra){
				arrOrdenadoresFecha.add(ordenador);
				System.out.println("En el if. Array: " + arrOrdenadoresFecha);
			}	
		}
		System.out.println("Despues del foreach. Array: " + arrOrdenadoresFecha);
		return arrOrdenadoresFecha;
	}


}