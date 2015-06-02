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
			MarcasSobremesa.generarOpcionesMenu());
	
	
	/*
	 * Men� Modelos Sobremesa
	 */
	private static Menu menuModelos = new Menu("MENU MARCAS SOBREMESA", 
			ModelosSobremesa.generarOpcionesMenu());
	
	/*
	 * Objeto concesionario de la clase Concesionario
	 */
	static TiendaOrdenador almacenOrdenador = new TiendaOrdenador();

	/**
	 * @param args
	 * 				Argumentos del main
	 */
	public static void main(String[] args){
		
		/**
		 * Bucle do while que muestra continuamente las opciones del men�
		 */
		do {
			/**
			 * Estructura switch con las diferentes opciones del men�
			 */
			switch (menu.gestionar()) {
			
			/*
			 * Comprar ordenador
			 */
			case 1:
				comprarOrdenador();
				break;
			
			/*
			 * Vender ordenador
			 */
			case 2:
				venderOrdenador();
				break;
			
			/*
			 * Obtener ordenador
			 */
			case 3:
				getOrdenador();
				break;
			
			/*
			 * Mostrar tienda
			 */
			case 4:
				System.out.println(almacenOrdenador);
				break;
				
			/*
			 * Muestra total de ordenadores en la tienda
			 */
			case 5:
				System.out.println("Hay " + almacenOrdenador.size() + " ordenador/es en el almac�n");
				break;
				
			/*
			 * Ordenadores por fecha
			 */
			case 6:// Mostrar Ordenadores por fecha
				System.out.println(almacenOrdenador.getOrdenadoresFecha(Teclado.leerCadena("Dime la fecha")));
				break;

			/*
			 * Cualquier otro n�mero sale del bucle
			 */
			default:
				System.out.println("Adios");
				return;
			}
		} while (true);
	}

	/**
	 * Obtener ordenador
	 */
	private static void getOrdenador() {
		Ordenador ordenador;
		try{
			ordenador = almacenOrdenador.get(Teclado.leerCadena("Introduce el n�mero de serie"));
			System.out.println(ordenador);	
		}catch(Exception e){
			System.out.println(e.getMessage() + " El ordenador no se puede mostrar.");
		}			
	}

	/**
	 * Eliminar ordenador
	 */
	private static void venderOrdenador(){
		if (almacenOrdenador
				.eliminar(Teclado.leerCadena("Dime el n�mero de serie")))
			System.out.println("Se ha eliminado correctamente");
		else
			System.out.println("No se ha podido eliminar");
	}

	/**
	 * A�adir un ordenador
	 */
	private static void comprarOrdenador(){
		if (almacenOrdenador.annadirOrdenador(Teclado.leerCadena("Dime el n�mero de serie"), pedirPantalla(), pedirRatonTeclado(), pedirMarca(), pedirModelo()))
			System.out.println("Ordenador a�adido con �xito"); 
		else
			System.out.println("No se ha podido a�adir"); 
	}


	/**
	 * Pide marca para el ordenador
	 * @return la marca escogida
	 */
	private static MarcasSobremesa pedirMarca() {
		int opcion = menuMarcas.gestionar();
		MarcasSobremesa[] arrMarcas = MarcasSobremesa.getValues();
		if (opcion == arrMarcas.length + 1)
			return null;
		return arrMarcas [opcion - 1];
	}

	/**
	 * Pide modelo
	 * 
	 * @return
	 * 		Opci�n de Modelo escogida
	 */
	private static ModelosSobremesa pedirModelo() {
		int opcion = menuModelos.gestionar();
		ModelosSobremesa[] arrModelos = ModelosSobremesa.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	/**
	 * Pide pantalla
	 * 
	 * @return
	 * 		Opci�n de Pantalla recogida
	 */
	private static Pantalla pedirPantalla() {
		int opcion = menuPantallas.gestionar();
		Pantalla[] arrPantallas = Pantalla.getValues();
		if (opcion == arrPantallas.length + 1)
			return null;
		return arrPantallas[opcion - 1];
	}

	private static boolean pedirRatonTeclado() {
		String opcion = Teclado.leerCadena("�Quieres rat�n y teclado?");
		if (opcion == "SI")
			return true;
		return false;
	}
}
