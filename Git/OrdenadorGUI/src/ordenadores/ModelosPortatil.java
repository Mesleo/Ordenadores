package ordenadores;

public enum ModelosPortatil {

	SATELLITEB100(MarcasPortatil.TOSHIBA, 340.80f),
	
	SATELLITEL70(MarcasPortatil.TOSHIBA, 480.70f),
	
	SATELLITEZ50(MarcasPortatil.TOSHIBA, 600.00f),
	
	X205TA(MarcasPortatil.ASUS, 400.80f),
	
	X554LD(MarcasPortatil.ASUS, 500.70f),
	
	N551JQ(MarcasPortatil.ASUS, 650.30f),
	
	SVF1521(MarcasPortatil.SONYVAIO, 648.25f),
	
	F1521(MarcasPortatil.SONYVAIO, 890.80f),
	
	MACBOOKAIR(MarcasPortatil.APPLE, 999.45f),
	
	MACBOOKPRO(MarcasPortatil.APPLE, 1449.00f);

	
	private MarcasPortatil mportatil;
	
	private float precio;
	
	

	ModelosPortatil(MarcasPortatil mportatil, float precio){
		this.precio = precio;
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


	public MarcasPortatil getMportatil() {
		return mportatil;
	}

	public void setMportatil(MarcasPortatil mportatil) {
		this.mportatil = mportatil;
	}
	
}
