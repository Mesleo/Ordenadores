package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import ordenadores.TiendaOrdenador;
import java.awt.Font;

/**
 * Ventana que muestra el total de ordenadores del almacen
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class TotalOrdenadores extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Contructor de la ventana TotalOrdenadores
	 * 
	 * @param almacen Almacén de TiendaOrdenador
	 */
	public TotalOrdenadores(TiendaOrdenador almacen) {
		setBounds(200, 180, 451, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHay = new JLabel("Hay");
		lblHay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHay.setBounds(101, 39, 33, 14);
		contentPane.add(lblHay);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Times New Roman", textField.getFont().getStyle(), textField.getFont().getSize() + 4));
		textField.setEditable(false);
		textField.setBounds(144, 36, 33, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		int i = almacen.size();
		String total = String.valueOf(i);
		textField.setText(total);
		
		JLabel lblCochesEnEl = new JLabel("ordenador/es en el almacen");
		lblCochesEnEl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCochesEnEl.setBounds(187, 33, 193, 27);
		contentPane.add(lblCochesEnEl);
	}
}
