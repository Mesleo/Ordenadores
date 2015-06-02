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
	
	/**
	 * Nombre del almacen
	 */
	private final String nombre = "Informática Benítez";

	/**
	 * Añade un coche al almacen
	 * 
	 * @param numSerie
	 *            Representa la matrícula del ordenador a añadir
	 * @param pantalla
	 *            Representa la pantalla del ordenador a añadir
	 * @param modelo
	 *            Representa el modelo del ordenador a añadir
	 * @return true si el ordenador se añade, false en otro caso (el ordenador es null o
	 *         el ordenador ya está contenido en el almacen)
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
	 *            Representa el número de serie del ordenador a eliminar
	 * @return true si el ordenador se elimina, false en otro caso (el ordenador no está
	 *         en el almacen)
	 */
	public boolean eliminar(String numSerie) {
		return almacen.remove(Sobremesa.instanciarOrdenador(numSerie));
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
	 * @param numSerie
	 *            Representa el número de serie a buscar
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