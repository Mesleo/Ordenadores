package ordenadores;

import java.util.ArrayList;

public enum Componentes {

	/**
	 * Representa la placa base ASUS
	 */
	ASUS(CrearPropioOrdenador.PLACABASE, (85.50f)),
	
	/**
	 * Representa la placa base ASROCK
	 */
	ASROCK(CrearPropioOrdenador.PLACABASE, (111.50f)),
	
	/**
	 * Representa la placa base MSI
	 */
	MSI(CrearPropioOrdenador.PLACABASE, (182.87f)),
	
	/**
	 * Representa el procesador AMDFM2
	 */
	AMDFM2(CrearPropioOrdenador.PROCESADOR, (45.50f)),
	
	/**
	 * Representa el procesador AM3
	 */
	AM3(CrearPropioOrdenador.PROCESADOR, (67.20f)),
	
	/**
	 * Representa el procesador INTELI5
	 */
	INTELI5(CrearPropioOrdenador.PROCESADOR, (182.00f)),

	/**
	 * Representa el procesador INTELI7
	 */
	INTELI7(CrearPropioOrdenador.PROCESADOR, (252.99f)),
	
	/**
	 * Representa la memoria RAM de 4GB
	 */
	CUATROGB(CrearPropioOrdenador.RAM, (60.50f)),
	
	/**
	 * Representa la memoria RAM de 8GB
	 */
	OCHOGB(CrearPropioOrdenador.RAM, (95.20f)),
	
	/**
	 * Representa la memoria RAM de 16GB
	 */
	DIECISEISGB(CrearPropioOrdenador.RAM, (220.00f)),
	
	/**
	 * Representa el disco duro de 500GB
	 */
	QUINIENTOSGB(CrearPropioOrdenador.DISCODURO, (40.50f)),
	
	/**
	 * Representa el disco duro de 1TB
	 */
	UNTB(CrearPropioOrdenador.DISCODURO, (62.20f)),
	
	/**
	 * Representa el disco duro de 2TB
	 */
	DOSTB(CrearPropioOrdenador.DISCODURO, (115.00f)),
	
	/**
	 * Representa la tarjeta gráfica de 1GB
	 */
	UNGB(CrearPropioOrdenador.TARJETAGRAFICA, (40.50f)),
	
	/**
	 * Representa la tarjeta gráfica de 2GB
	 */
	DOSGB(CrearPropioOrdenador.TARJETAGRAFICA, (62.20f)),
	
	/**
	 * Representa la tarjeta gráfica de 1GB
	 */
	CUATROCIENTOS(CrearPropioOrdenador.FUENTEALIMENTACION, (30.50f)),
	
	/**
	 * Representa la tarjeta gráfica de 2GB
	 */
	QUINIENTOS(CrearPropioOrdenador.FUENTEALIMENTACION, (41.20f)),
	
	/**
	 * Representa la tarjeta gráfica de 2GB
	 */
	SEISCIENTOS(CrearPropioOrdenador.FUENTEALIMENTACION, (50.20f));
	
	
	
	/**
	 * Modelo de sobremesa
	 */
	private CrearPropioOrdenador propio;
	
	/**
	 * Precio en decimal que se aplicará a cada componente que se añada
	 */
	private float precio;
	
	private MarcasOrdenador marca;
	
	Componentes(CrearPropioOrdenador propio, float precio){
		this.setPropioOrdenador(propio);
		this.precio = precio;
	}
	

	public static Object[] getArray(CrearPropioOrdenador pieza){
		ArrayList<Componentes> arrayList = new ArrayList<Componentes>();
		for (Componentes componente : values()) {
			if(componente.propio == pieza) 
				arrayList.add(componente);
		}
		return arrayList.toArray();
	}

	public CrearPropioOrdenador getPropio() {
		return propio;
	}

	public void setPropioOrdenador(CrearPropioOrdenador propio) {
		this.propio = propio;
	}

	public float getPrecio() {
		return precio;
	}

	public MarcasOrdenador getMarca() {
		return marca;
	}


	public void setMarca(MarcasOrdenador marca) {
		this.marca = marca;
	}
	
}
