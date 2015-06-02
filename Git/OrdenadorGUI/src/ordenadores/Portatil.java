package ordenadores;

public class Portatil extends Ordenador {

	private boolean raton;
	
	private boolean teclado;
	
	protected Portatil(String numSerie, Pantalla pantalla, boolean raton, boolean teclado) {
		super(numSerie, pantalla);
		this.raton = raton;
		this.teclado = teclado;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Método abstracto que hereda de la clase padre Ordenador
	 * 
	 */
	@Override
	public float calcularPrecio() {
		return 0;
	}

	public boolean isRaton() {
		return raton;
	}

	public void setRaton(boolean raton) {
		this.raton = raton;
	}

	public boolean isTeclado() {
		return teclado;
	}

	public void setTeclado(boolean teclado) {
		this.teclado = teclado;
	}

	
	
}
