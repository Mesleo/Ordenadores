package gui;

import javax.swing.JOptionPane;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPorNumeroDeSerie extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarPorNumeroDeSerie(final TiendaOrdenador concesionario) {
		super();
		setTitle("Mostrar por matricula");
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordenador coche = concesionario.get(textField.getText());
				if (coche != null) {
					mostrarCoche(coche);
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No existe ningún coche con esa matricula.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	private void mostrarCoche(Ordenador coche) {
		switch (coche.getPantalla()) {
		case PLATA:
			radioButtonPlata.setSelected(true);
			break;
		case ROJO:
			radioButtonRojo.setSelected(true);
			break;
		case AZUL:
			radioButtonAzul.setSelected(true);
		}
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
	}

}