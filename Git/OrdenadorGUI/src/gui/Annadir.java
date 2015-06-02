package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Annadir extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Annadir(final TiendaOrdenador almacen) {
		super();
		setTitle("Alta");
		
		eliminar.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel(MarcasSobremesa.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (almacen.annadirSobreMesa(textField.getText(), getColor(),
						(ModelosSobremesa) comboBoxModelo.getSelectedItem())){
					JOptionPane.showMessageDialog(contentPanel,
							"Ordenador añadido con éxito.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
					Generar.setModificado(true);
					Generar.setGuardado(false);
				}
				else{
					JOptionPane.showMessageDialog(contentPanel,
							"El ordenador no se ha podido añadir.", "Error",
							JOptionPane.ERROR_MESSAGE);
				Generar.setModificado(false);
				}
			}
		});
	}
	
	private Object[] getModelo(JComboBox<MarcasSobremesa> comboBoxMarca) {
		MarcasSobremesa marca = (MarcasSobremesa) comboBoxMarca.getSelectedItem();
		ArrayList<ModelosSobremesa> modelos = new ArrayList<ModelosSobremesa>();
		for (ModelosSobremesa m : ModelosSobremesa.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
	
	private Pantalla getColor() {
		if (radioButtonPlata.isSelected())
			return Pantalla.PLATA;
		else if (radioButtonRojo.isSelected())
			return Pantalla.ROJO;
		else if (radioButtonAzul.isSelected())
			return Pantalla.AZUL;
		else
			return null;
	}

}