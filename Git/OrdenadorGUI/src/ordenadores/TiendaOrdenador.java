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
 * <li>Compra de un ordenador(se pedirá número de serie, tamaño de pantalla, etc. 
 * Esto variará en función de el tipo de ordenador).</li>
 * <li>Venta de un ordenador (por número de serie).</li>
 * <li>Mostrar un ordenador (por número de serie).</li>
 * <li>Mostrar almacén (todos los ordenadores de la tienda, portátiles o sobremesa).</li>
 * <li>Contar el número de ordenadores en la tienda.</li>
 * <li>Mostrar ordenadores por fecha de compra.</li>
 * </ol>
 * Lógicamente, no podrá añadirse un ordenador inválido o ya contenido (no pueden
 * existir dos ordenadores con el mismo número de serie en el almacén). Por cada
 * ordenador que se compre, han de conocerse todas sus características. Ninguna
 * de las características del ordenador puede ser por defecto.
 * 
 * @author Javier Benitez del Pozo
 * @version 1.0
 */
public class TiendaOrdenador implements Serializable{
	
	/**
	 * Colección de ordenadores. No puede tener null.
	 */
	private ArrayList<Ordenador> almacen = new ArrayList<Ordenador>();
	
	private Ordenador ordenador;
	
	/**
	 * Nombre del almacen
	 */
	private final String nombre = "Informática Benítez";

	
	public boolean annadirOrdenador(Ordenador ordenador) {
		if (ordenador == null || almacen.contains(ordenador))
			return false;
		return almacen.add(ordenador);
	}


	/**
	 * Elimina un ordenador del almacen
	 * 
	 * @param numSerie
	 *            Representa el número de serie del ordenador a eliminar
	 * @return true si el ordenador se elimina, false en otro caso (el ordenador no está
	 *         en el almacen)
	 */
	public boolean eliminar(Ordenador ordenador) {
//		Ordenador ordenador2 = ordenador;
		return almacen.remove(ordenador);
	}

	/**
	 * Devuelve el número de ordenadores del almacen
	 * 
	 * @return Número de ordenadores del almacen
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el ordenador indicado por el número de serie
	 * 
	 * @param string
	 *            Representa el número de serie a buscar
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