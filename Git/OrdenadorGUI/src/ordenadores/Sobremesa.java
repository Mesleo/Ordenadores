package ordenadores;

public class Sobremesa extends Ordenador {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Booleano de raton teclado, está a false de inicio
	 */
	private boolean raton_teclado;
	
	/**
	 * Marca de ordenadores sobremesa
	 */
	private MarcasSobremesa marcasobremesa;

	/**
	 * Modelo de ordenadores sobremesa
	 */
	private ModelosSobremesa modelo;
	
	/**
	 * Modelo de ordenadores sobremesa
	 */

	/**
	 * Contructor con sólo el argumento número de serie
	 * @param numSerie
	 * 				Parámetro unívoco e identificador de cada Sobremesa
	 */
	Sobremesa(String numSerie){
		super(numSerie);
	}

	Sobremesa(String numSerie, Pantalla pantalla, boolean rt, MarcasSobremesa marcassobremesa, ModelosSobremesa modelo){
		super(numSerie, pantalla);
		this.raton_teclado = rt;
		this.marcasobremesa = marcassobremesa;
		this.modelo = modelo;
	}

	public static Sobremesa instanciarSobremesa(String numSerie,
			Pantalla pantalla, boolean rt, MarcasSobremesa marcassobremesa, ModelosSobremesa modelo) {
		try{
			if (esValido(numSerie) && pantalla != null && marcassobremesa != null && modelo != null)
				return new Sobremesa(numSerie, pantalla, rt, marcassobremesa, modelo);
		}catch(Exception e){
			System.out.println("No se ha podido instanciar");
			e.printStackTrace();
		}
		return null;
	}
	

	public static Sobremesa instanciarOrdenador(String numSerie) {
		try{
			if (esValido(numSerie))
				return new Sobremesa(numSerie);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @return the raton_teclado
	 */
	public boolean isRaton_teclado() {
		return raton_teclado;
	}


	/**
	 * @param raton_teclado the raton_teclado to set
	 */
	public void setRaton_teclado(boolean raton_teclado) {
		this.raton_teclado = raton_teclado;
	}


	/**
	 * @return the marcasobremesa
	 */
	public MarcasSobremesa getMarcasobremesa() {
		return marcasobremesa;
	}


	/**
	 * @param marcasobremesa the marcasobremesa to set
	 */
	public void setMarcasobremesa(MarcasSobremesa marcasobremesa) {
		this.marcasobremesa = marcasobremesa;
	}
	


	public ModelosSobremesa getModelo() {
		return modelo;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Representa el nuevo modelo del coche
	 */
	private void setModelo(ModelosSobremesa modelo) {
		this.modelo = modelo;
	}

	
	/**
	 * Método abstracto que hereda de la clase padre Ordenador
	 * 
	 */
	@Override
	public float calcularPrecio() {
		return 0;
		
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sobremesa:\t\n\tFecha compra: " + fechaActual
				+ "\n\tNúmero de serie: " + numSerie
				+ "\n\tPantalla: " + pantalla
				+ "\n\tTiene ratón y teclado: " + raton_teclado
				+ "\n\tMarca: " + marcasobremesa
				+ "\n\tModelo: " + modelo;
	}
}
