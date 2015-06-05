package gui;

import javax.swing.JOptionPane;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Eliminar extends VentanaPrincipal {

	private Mostrar mostrar;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean modificado;

	/**
	 * Create the dialog.
	 */
	public Eliminar(final TiendaOrdenador almacen) {
		super();
		setTitle("Baja");
		
		annadir.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
	
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobremesa ordenador = (Sobremesa)almacen.get(new Sobremesa(textField.getText()));
				Portatil portatil = (Portatil)almacen.get(new Portatil(textField.getText()));
				PropioPC propio = (PropioPC)almacen.get(new PropioPC(textField.getText()));
				if (ordenador != null) {
					int n = JOptionPane.showOptionDialog(contentPanel,
							"¿Está seguro de que desea eliminarlo?", "Confirmar",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					switch (n) {
					case JOptionPane.YES_OPTION:
						almacen.eliminar(ordenador);
						JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
						clear();
						Generar.setModificado(true);
						break;
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha podido eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
					Generar.setModificado(false);
				}
			}
		});
	}
	
	private void clear() {
		textField.setText("");
		grupoTecladoRaton.clearSelection();
		comboBoxMarca.setSelectedItem(null);
		comboBoxModelo.setSelectedItem(null);	
	}

}