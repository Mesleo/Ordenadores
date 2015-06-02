/**
 * 
 */
package ordenadores;


/**
 * Se limitarán los modelos de coches a siete: Córdoba (marca Seat), Toledo
 * (marca Seat), Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca BMW),
 * Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al dar de
 * alta al coche podrá implementarse un método pedirModelo que mediante la
 * gestión de un menú, devolverá el modelo indicado.
 * 
 * @author Javier Benítez del Pozo
 * @version 1.0
 */
public enum ModelosSobremesa {

	/**
	 * Representa el modelo CP6230
	 */
	CP6230 (MarcasSobremesa.ASUS, "Gama baja", (350.25f)),

	/**
	 * Representa el modelo CM6870
	 */
	CM6870 (MarcasSobremesa.ASUS, "Multimedia", (480.45f)),

	/**
	 * Representa el modelo ROG_CG8580
	 */
	ROG_CG8580 (MarcasSobremesa.ASUS, "Gamming", (750.65f)),

	/**
	 * Representa el modelo PAVILION
	 */
	PAVILION (MarcasSobremesa.SONYVAIO, "Gama baja", (550.25f)),

	/**
	 * Representa el modelo PHOENIX
	 */
	PHOENIX (MarcasSobremesa.SONYVAIO, "Multimedia", (750.45f)),

	/**
	 * Representa el modelo ENVY
	 */
	ENVY (MarcasSobremesa.SONYVAIO, "Gamming", (1050.85f)),

	/**
	 * Representa el modelo MACMINI
	 */
	MACMINI (MarcasSobremesa.APPLE, "Gama media alta", (500.00f)),

	/**
	 * Representa el modelo IMAC
	 */
	IMAC (MarcasSobremesa.APPLE, "Gama media", (1129.00f)),

	/**
	 * Representa el modelo MACPRO
	 */
	MACPRO (MarcasSobremesa.APPLE, "Gama alta", (3048.99f)),
	
	/**
	 * Representa la placa base
	 */
	PLACABASE(MarcasSobremesa.CREAR_MI_PROPIO_ORDENADOR, "Placa base", 0f),
	
	/**
	 * Representa el procesador
	 */
	PROCESADOR(MarcasSobremesa.CREAR_MI_PROPIO_ORDENADOR, "Procesador", 0f),
	
	/**
	 * Representa la memoria RAM
	 */
	RAM(MarcasSobremesa.CREAR_MI_PROPIO_ORDENADOR, "RAM", 0f),
	
	/**
	 * Representa el disco duro
	 */
	DISCODURO(MarcasSobremesa.CREAR_MI_PROPIO_ORDENADOR, "Disco duro", 0f),
	
	/**
	 * Representa la tarjeta gráfica
	 */
	TARJETAGRAFICA(MarcasSobremesa.CREAR_MI_PROPIO_ORDENADOR, "Tarjeta gráfica", 0f),
	
	/**
	 * Representa la fuente de alimentación
	 */
	FUENTEALIMENTACION(MarcasSobremesa.CREAR_MI_PROPIO_ORDENADOR, "Fuente de alimentación", 0f);

	private float precio;
	
	private String comentario;
	
	/**
	 * Marca de MarcasSobremesa
	 */
	private MarcasSobremesa marcasobremesa;

	/**
	 * Construye un nuevo modelo de marca especificada
	 * 
	 * @param marca
	 *            Representa la marca del nuevo modelo
	 */
	private ModelosSobremesa(MarcasSobremesa marca, String comentario, float precio) {
		this.marcasobremesa = marca;
		this.setComentario(comentario);
	}

	/**
	 * Devuelve la marca del modelo
	 * 
	 * @return Marca del modelo
	 */
	public MarcasSobremesa getMarca() {
		return marcasobremesa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name();

	}

	// Para el menú-------------------------------------------------
	
	/**
	 * Array de modelos
	 */
	private static final ModelosSobremesa[] VALUES = ModelosSobremesa.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del menú
	 * 
	 * @return Array de cadenas con las opciones del menú
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (ModelosSobremesa modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de modelos
	 * 
	 * @return Array de modelos
	 */
	public static ModelosSobremesa[] getValues() {
		return VALUES;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}