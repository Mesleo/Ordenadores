package ordenadores;

public enum Componentes {

	/**
	 * Representa la placa base ASUS
	 */
	ASUS(ModelosSobremesa.PLACABASE, 85.50f),
	
	/**
	 * Representa la placa base ASROCK
	 */
	ASROCK(ModelosSobremesa.PLACABASE, 111.50f),
	
	/**
	 * Representa la placa base MSI
	 */
	MSI(ModelosSobremesa.PLACABASE, 182.87f),
	
	/**
	 * Representa el procesador AMDFM2
	 */
	AMDFM2(ModelosSobremesa.PROCESADOR, 45.50f),
	
	/**
	 * Representa el procesador AM3
	 */
	AM3(ModelosSobremesa.PROCESADOR, 67.20f),
	
	/**
	 * Representa el procesador INTELI5
	 */
	INTELI5(ModelosSobremesa.PROCESADOR, 182.00f),

	/**
	 * Representa el procesador INTELI7
	 */
	INTELI7(ModelosSobremesa.PROCESADOR, 252.99f),
	
	/**
	 * Representa la memoria RAM de 4GB
	 */
	CUATROGB(ModelosSobremesa.RAM, 60.50f),
	
	/**
	 * Representa la memoria RAM de 8GB
	 */
	OCHOGB(ModelosSobremesa.RAM, 95.20f),
	
	/**
	 * Representa la memoria RAM de 16GB
	 */
	DIECISEISGB(ModelosSobremesa.RAM, 220.00f),
	
	/**
	 * Representa el disco duro de 500GB
	 */
	QUINIENTOSGB(ModelosSobremesa.RAM, 40.50f),
	
	/**
	 * Representa el disco duro de 1TB
	 */
	UNTB(ModelosSobremesa.RAM, 62.20f),
	
	/**
	 * Representa el disco duro de 2TB
	 */
	DOSTB(ModelosSobremesa.RAM, 115.00f),
	
	/**
	 * Representa la tarjeta gráfica de 1GB
	 */
	UNGB(ModelosSobremesa.RAM, 40.50f),
	
	/**
	 * Representa la tarjeta gráfica de 2GB
	 */
	DOSGB(ModelosSobremesa.RAM, 62.20f),
	
	/**
	 * Representa la tarjeta gráfica de 1GB
	 */
	CUATROCIENTOSVATIOS(ModelosSobremesa.RAM, 30.50f),
	
	/**
	 * Representa la tarjeta gráfica de 2GB
	 */
	QUINIENTOSVATIOS(ModelosSobremesa.RAM, 41.20f),
	
	/**
	 * Representa la tarjeta gráfica de 2GB
	 */
	SEISCIENTOSVATIOS(ModelosSobremesa.RAM, 50.20f);
	
	
	
	/**
	 * Modelo de sobremesa
	 */
	private ModelosSobremesa modelosobremesa;
	
	/**
	 * Precio en decimal que se aplicará a cada componente que se añada
	 */
	private float precio;
	
	Componentes(ModelosSobremesa modelo, float precio){
		this.setModelosobremesa(modelo);
	}

	public ModelosSobremesa getModelosobremesa() {
		return modelosobremesa;
	}

	public void setModelosobremesa(ModelosSobremesa modelosobremesa) {
		this.modelosobremesa = modelosobremesa;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
