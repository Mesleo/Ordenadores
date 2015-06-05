package ordenadores;

public enum ModelosOrdenador {
	
	/**
	 * Representa el modelo CP6230
	 */
	CP6230 (MarcasOrdenador.ASUS,(350.25f)),

	/**
	 * Representa el modelo CM6870
	 */
	CM6870 (MarcasOrdenador.ASUS, (480.45f)),

	/**
	 * Representa el modelo ROG_CG8580
	 */
	ROG_CG8580 (MarcasOrdenador.ASUS, (750.65f)),

	/**
	 * Representa el modelo PAVILION
	 */
	PAVILION (MarcasOrdenador.SONYVAIO, (550.25f)),

	/**
	 * Representa el modelo PHOENIX
	 */
	PHOENIX (MarcasOrdenador.SONYVAIO, (750.45f)),

	/**
	 * Representa el modelo ENVY
	 */
	ENVY (MarcasOrdenador.SONYVAIO, (1050.85f)),

	/**
	 * Representa el modelo MACMINI
	 */
	MACMINI (MarcasOrdenador.APPLE, (500.00f)),

	/**
	 * Representa el modelo IMAC
	 */
	IMAC (MarcasOrdenador.APPLE, (1129.00f)),

	/**
	 * Representa el modelo MACPRO
	 */
	MACPRO (MarcasOrdenador.APPLE,(3048.99f)),
	
	/**
	 * Representa el modelo de portátil SATELLITEB100
	 */
	SATELLITEB100(MarcasOrdenador.TOSHIBA, (340.80f)),

	/**
	 * Representa el modelo de portátil SATELLITEL70
	 */
	SATELLITEL70(MarcasOrdenador.TOSHIBA, (480.70f)),

	/**
	 * Representa el modelo de portátil SATELLITEZ50
	 */
	SATELLITEZ50(MarcasOrdenador.TOSHIBA, (600.00f)),

	/**
	 * Representa el modelo de portátil X205TA
	 */
	X205TA(MarcasOrdenador.ASUS_PORTATIL, (400.80f)),

	/**
	 * Representa el modelo de portátil X554LD
	 */
	X554LD(MarcasOrdenador.ASUS_PORTATIL, (500.70f)),

	/**
	 * Representa el modelo de portátil N551JQ
	 */
	N551JQ(MarcasOrdenador.ASUS_PORTATIL, (650.30f)),

	/**
	 * Representa el modelo de portátil SVF1521
	 */
	SVF1521(MarcasOrdenador.SONYVAIO_PORTATIL, (648.25f)),

	/**
	 * Representa el modelo de portátil F1521
	 */
	F1521(MarcasOrdenador.SONYVAIO_PORTATIL, (890.80f)),

	/**
	 * Representa el modelo de portátil MACBOOKAIR
	 */
	MACBOOKAIR(MarcasOrdenador.APPLE_PORTATIL, (999.45f)),

	/**
	 * Representa el modelo de portátil MACBOOKPRO
	 */
	MACBOOKPRO(MarcasOrdenador.APPLE_PORTATIL, (1449.00f));

	
	private MarcasOrdenador marca;
	
	private float precio;
	
	

	ModelosOrdenador(MarcasOrdenador modelo, float precio){
		this.marca = modelo;
		this.precio = precio;
	}
	
	/**
	 * Array de modelos
	 */
	private static final ModelosOrdenador[] VALUES = ModelosOrdenador.values();
	
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (ModelosOrdenador modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public MarcasOrdenador getMarca() {
		return marca;
	}

	public void setMarca(MarcasOrdenador marca) {
		this.marca = marca;
	}
	
}
