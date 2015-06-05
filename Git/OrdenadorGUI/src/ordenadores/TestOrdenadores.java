/**
 * Paquete concesionario.pgn.examenMarzo.concesionarioCoches
 */
package ordenadores;

/**
 * Importa el paquete concesionario.pgn.examenMarzo.utiles.Menu
 */
/**
 * Importa el paquete utiles.*
 */
import utiles.*;
import ordenadores.*;


/**
 * Queremos modelar una tienda de ordenadores en Java. Nos limitaremos a las
 * siguientes opciones: Comprar un ordenador (se pedir� n�mero de serie, tama�o de pantalla, marca de ordenador, modelo y otros atributos booleanos),
 * Vender un ordenador (por n�mero de serie), mostrar un ordenador (por n�mero de serie), mostrar
 * ordenadores (todo el almac�n) y mostrar ordenadores por fecha.
 * 
 * @author Javier Ben�tez del Pozo
 * 
 */
public class TestOrdenadores{
	
	/*
	 * Men� Test
	 */
	static Menu menu = new Menu("MENU TIENDA ORDENADORES", new String[] { 
			"Comprar ordenador","Vender ordenador", "Obtener ordenador por N� Serie",
			"Mostrar tienda", "Mostrar total de ordenadores", 
			"Ordenadores por fecha de compra", "Salir" });
	
	
	/*
	 * Men� Pantallas
	 */
	private static Menu menuPantallas = new Menu("MENU PANTALLAS",
			Pantalla.generarOpcionesMenu());
	
	/*
	 * Men� Pantallas
	 */
	private static Menu menuMarcas = new Menu("MENU MARCAS",
			MarcasOrdenador.generarOpcionesMenu());
	
	
	/*
	 * Men� Modelos Sobremesa
	 */
	private static Menu menuModelos = new Menu("MENU MARCAS SOBREMESA", 
			ModelosOrdenador.generarOpcionesMenu());
	
	/*
	 * Objeto concesionario de la clase Concesionario
	 */
	static TiendaOrdenador almacenOrdenador = new TiendaOrdenador();
	

	/**
	 * @param args
	 * 				Argumentos del main
	 */
	public static void main(String[] args){
		
		//Probando a a�adir distintos elementos con el mismo n�mero de serie

		Ordenador sobremesa = new Sobremesa(TipoOrdenador.SOBREMESA, "0000A",
				Pantalla.ONCE, 480, MarcasOrdenador.ASUS, ModelosOrdenador.CM6870, true);
		Ordenador sobremesa2 = new Sobremesa(TipoOrdenador.SOBREMESA, "0000A",
				Pantalla.ONCE, 480, MarcasOrdenador.ASUS, ModelosOrdenador.CM6870, true);
		System.out.println("M�todo de la interfaz Precio de la clase Sobremesa: "
				+ sobremesa.precio);
		Ordenador portatil = new Portatil(TipoOrdenador.PORTATIL, "B0000",
				Pantalla.VEINTISIETE, 150, MarcasOrdenador.APPLE_PORTATIL, ModelosOrdenador.CM6870, true, false);
		System.out.println("M�todo de la interfaz Precio de la clase Port�til: "
				+ portatil.precio);
		
		Ordenador portatil2 = new Portatil(TipoOrdenador.PORTATIL, "0000A",
				Pantalla.VEINTISIETE, 150, MarcasOrdenador.APPLE_PORTATIL, ModelosOrdenador.CM6870, true, false);
		
		
		//A�adidos
		System.out.println("Almacen con a�adidos");
		System.out.println("S1");almacenOrdenador.annadirOrdenador(sobremesa);
		System.out.println("S2");almacenOrdenador.annadirOrdenador(sobremesa2);
		System.out.println("P1");almacenOrdenador.annadirOrdenador(portatil);
		System.out.println("P2");almacenOrdenador.annadirOrdenador(portatil2);
		System.out.println("P1.2");almacenOrdenador.annadirOrdenador(portatil);
		Ordenador pc = sobremesa;
		System.out.println(almacenOrdenador.toString());
		//Eliminados
		System.out.println("Almcen con eliminados");
		almacenOrdenador.eliminar(pc);
		System.out.println(almacenOrdenador.toString());
		
		Ordenador s = (Ordenador)sobremesa;
		System.out.println("Transformado a clase padre: " + s);
		Ordenador s2 = (Ordenador)portatil2;
		System.out.println("Transformado a clase padre: " + s2);
		System.out.println("Igual igual: " + (s.numSerie == s2.numSerie));
		System.out.println("Equals con atributo: " + (s.numSerie.equals(s2.numSerie)));
		System.out.println("Equals: " + (s.equals(s2)));
		System.out.println("Contains: " + almacenOrdenador.equals(s));
		System.out.println("Contains: " + almacenOrdenador.equals(s2));
		System.out.println("Redondeo: " + redondear(2.6668742, 4));
	}
	
	 public static double redondear( double numero, int decimales ) {
		    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
		  }
}
