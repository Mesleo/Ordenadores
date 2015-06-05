/**
 * Paquete ordendadores
 */
package ordenadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	private Ordenador ordenador;
	
	/**
	 * Nombre del almacen
	 */
	private final String nombre = "Inform�tica Ben�tez";

	
	public boolean annadirOrdenador(Ordenador ordenador) {
		if (ordenador == null || almacen.contains(ordenador))
			return false;
		return almacen.add(ordenador);
	}


	/**
	 * Elimina un ordenador del almacen
	 * 
	 * @param numSerie
	 *            Representa el n�mero de serie del ordenador a eliminar
	 * @return true si el ordenador se elimina, false en otro caso (el ordenador no est�
	 *         en el almacen)
	 */
	public boolean eliminar(Ordenador ordenador) {
//		Ordenador ordenador2 = ordenador;
		return almacen.remove(ordenador);
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
	 * @param string
	 *            Representa el n�mero de serie a buscar
	 * @return Ordenador contenido en el almacen. null si no existe
	 */
	public Ordenador get(Ordenador ordenador) {
		Ordenador ordendador = ordenador;
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
			if(ordenador.getFechaCompra() == fechaCompra){
				arrOrdenadoresFecha.add(ordenador);
			}	
		}
		return arrOrdenadoresFecha;
	}

}