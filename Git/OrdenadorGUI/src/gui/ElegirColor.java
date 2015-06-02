package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;

public class ElegirColor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblColor;
	private JRadioButton radioButtonPlata;
	private JRadioButton radioButtonRojo;
	private JRadioButton radioButtonAzul;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton aceptar;
	private JButton salir;
	private MostrarPorFecha mostrarPorColor;

	/**
	 * Create the dialog.
	 */
	public ElegirColor(final TiendaOrdenador concesionario) {
		setTitle("Elegir color");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 298, 109);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(20, 11, 49, 14);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBounds(100, 7, 65, 23);
		buttonGroup.add(radioButtonPlata);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBounds(167, 7, 65, 23);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBounds(232, 7, 65, 23);
		buttonGroup.add(radioButtonAzul);
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(114, 48, 86, 23);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla color = getColor();
				if (color != null) {
					ArrayList<Ordenador> coches = concesionario
							.getOrdenadoresFecha(color);
					if (coches.isEmpty()) {
						JOptionPane.showMessageDialog(contentPanel,
								"No existe ningún coche de ese color.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					mostrarPorColor = new MostrarPorFecha(coches);
					mostrarPorColor.setVisible(true);
				} else
					JOptionPane.showMessageDialog(contentPanel,
							"Debes seleccionar un color.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		
		salir = new JButton("Salir");
		salir.setBounds(210, 48, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(lblColor);
		getContentPane().add(aceptar);
		getContentPane().add(salir);
		getContentPane().add(radioButtonPlata);
		getContentPane().add(radioButtonRojo);
		getContentPane().add(radioButtonAzul);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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