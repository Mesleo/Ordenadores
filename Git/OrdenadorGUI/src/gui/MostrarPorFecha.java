package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import ordenadores.Ordenador;
import ordenadores.Sobremesa;
import ordenadores.TiendaOrdenador;

public class MostrarPorFecha extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TiendaOrdenador almacen;
	private int indiceCoche = -1;

	/**
	 * Create the dialog.
	 */
	public MostrarPorFecha(TiendaOrdenador almacen2) {
		super();
		setTitle("Mostrar por color");
		
//		this.almacen = generarAlmacen(almacen2);
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buscar.setVisible(false);
		
		textField.setEnabled(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
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
		indiceCoche = 0;
		mostrarOrdenador(almacen.get(indiceCoche));
		comprobarBotones();
	}
	
	private void mostrarSiguiente() {
		mostrarOrdenador(almacen.get(++indiceCoche));
		comprobarBotones();
	}

	private void mostrarAnterior() {
		mostrarOrdenador(almacen.get(--indiceCoche));
		comprobarBotones();
	}
	
	private void mostrarOrdenador(Ordenador ordenador) {
//		ArrayList<Ordenador> arrOrdenadoresFecha = new ArrayList<Ordenador>();
//		for (Ordenador ordenador2 : almacen) {
//			System.out.println("Ordenador: " + ordenador2);
//			System.out.println("Antes del if. Array: " + arrOrdenadoresFecha);
//			if(ordenador2.getFechaActual() == textField.setText(ordenador.getFechaActual())){
//				arrOrdenadoresFecha.add(ordenador2);
//				System.out.println("En el if. Array: " + arrOrdenadoresFecha);
//			}	
//		}
//		comboBoxMarca.addItem(ordenador.getModelo().getMarca());
//		comboBoxMarca.setSelectedItem(ordenador.getModelo().getMarca());
//		comboBoxModelo.addItem(ordenador.getModelo());
//		comboBoxModelo.setSelectedItem(ordenador.getModelo());
	}
	
	private void comprobarBotones() {
		if (almacen.get(indiceCoche + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);

		if (almacen.get(indiceCoche - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
	}
	
//	private TiendaOrdenador generarAlmacen(ArrayList<Ordenador> concesionario) {
//		TiendaOrdenador almacenPorFecha = new TiendaOrdenador();
//		for (Ordenador ordenador : concesionario) {
//			almacenPorFecha.annadirSobreMesa(ordenador.getFechaActual(),
//					ordenador.getPantalla(), Sobremesa.getModelo());
//		}
//		return almacenPorFecha;
//	}
	
}