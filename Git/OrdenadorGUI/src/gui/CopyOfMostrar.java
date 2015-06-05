package gui;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CopyOfMostrar extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TiendaOrdenador almacen;
	private int indiceOrdenador = -1;

	/**
	 * Create the dialog.
	 */
	public CopyOfMostrar(TiendaOrdenador almacen) {
		super();
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setTitle("Mostrar almacén");
		
		this.almacen = almacen;
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buscar.setVisible(false);
		
		textField.setEnabled(false);
		
		radio11.setEnabled(false);
		radio15.setEnabled(false);
		radio21.setEnabled(false);
		radio27.setEnabled(false);

		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		comboBoxPlaca.setEnabled(false);
		comboBoxProces.setEnabled(false);
		comboBoxRam.setEnabled(false);
		comboBoxDiscoDuro.setEnabled(false);
		comboBoxTgrafica.setEnabled(false);
		comboBoxAlimentacion.setEnabled(false);
		
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
	}
	
	void actualizar() {
		if (almacen.size() == 0) {
			return;
		}
		indiceOrdenador = 0;
		mostrarOrdenador(almacen.get(indiceOrdenador));
		comprobarBotones();		
	}
	
	private void mostrarSiguiente() {
		mostrarOrdenador(almacen.get(++indiceOrdenador));
		comprobarBotones();
	}

	private void mostrarAnterior() {
		mostrarOrdenador(almacen.get(--indiceOrdenador));
		comprobarBotones();
	}
	
	private void mostrarOrdenador(Ordenador ordenador) {
		textField.setText(ordenador.getNumSerie());
		switch (ordenador.getPantalla()) {
			case ONCE:
				radio11.setSelected(true);
				break;
			case QUINCE:
				radio15.setSelected(true);
				break;
			case VEINTIUNA:
				radio21.setSelected(true);
				break;
			case VEINTISIETE:
				radio27.setSelected(true);
				break;
		}
		if (ordenador.getMarca() == MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
			PropioPC propio = (PropioPC) ordenador;
			comboBoxMarca.setSelectedItem(propio.getMarca());
			comboBoxPlaca.setSelectedItem(propio.getPlaca());
			comboBoxProces.setSelectedItem(propio.getProcesador());
			comboBoxRam.setSelectedItem(propio.getRam());
			comboBoxDiscoDuro.setSelectedItem(propio.getDiscoDuro());
			comboBoxTgrafica.setSelectedItem(propio.getTarjetaGrafica());
			comboBoxAlimentacion.setSelectedItem(propio.getFuenteAlimentacion());
			return;
		}
		if (ordenador.getTipo() == TipoOrdenador.SOBREMESA && ordenador.getMarca() != MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
			Ordenador sobremesa = ordenador;
			comboBoxMarca.addItem(sobremesa.getModelo().getMarca());
			comboBoxMarca.setSelectedItem(sobremesa.getModelo().getMarca());
			comboBoxModelo.addItem(sobremesa.getModelo());
			comboBoxModelo.setSelectedItem(sobremesa.getModelo());
		}else if (ordenador.getTipo() == TipoOrdenador.PORTATIL){
			Portatil portatil = (Portatil) ordenador;
			comboBoxMarca.addItem(portatil.getModelo().getMarca());
			comboBoxMarca.setSelectedItem(portatil.getModelo().getMarca());
			comboBoxModelo.addItem(portatil.getModelo());
			comboBoxModelo.setSelectedItem(portatil.getMarca());
		}
	}
	
	private void comprobarBotones() {
		if (almacen.get(indiceOrdenador + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);

		if (almacen.get(indiceOrdenador - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
	}
	
}