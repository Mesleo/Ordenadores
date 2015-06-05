package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ordenadores.Ordenador;
import ordenadores.TiendaOrdenador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Fecha extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MostrarPorFecha mostrarporfecha;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfFecha;
	
	/**
	 * Patrón para una fecha válida
	 */
	static final protected Pattern patternFecha= Pattern
			.compile("^(((0?[1-9]|1\\d|2[0-8])/(0?[1-9]|1[0-2]))|"
					+ "(((29)|(30))/(0?[1-9&&[^2]]|1[0-2]))|"
					+ "((31/)[1|3|5|7|8|10|12]))/(((19)|(20))\\d{2})$");
	
	/**
	 * Array de ordenadores para almacenar los de la misma fecha
	 */
	private ArrayList<Ordenador> ordenadores;

	/**
	 * Create the dialog.
	 */
	public Fecha(final TiendaOrdenador almacen) {
		setBounds(100, 100, 378, 118);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIntroduceFecha = new JLabel("Introduce la fecha:\r\n\r\n");
			lblIntroduceFecha.setBounds(10, 11, 139, 14);
			contentPanel.add(lblIntroduceFecha);
		}
		{
			tfFecha = new JTextField();
			tfFecha.setBounds(159, 8, 86, 20);
			contentPanel.add(tfFecha);
			tfFecha.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String fecha = tfFecha.getText();
						if (esValidaFecha(fecha)) {
							ordenadores = almacen
									.getOrdenadoresFecha(fecha);
							if (ordenadores.isEmpty()) {
								JOptionPane.showMessageDialog(contentPanel,
										"No existe ningún ordenador comprado ese día.",
										"Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							mostrarporfecha = new MostrarPorFecha(ordenadores);
							mostrarporfecha.setVisible(true);
						} else
							JOptionPane.showMessageDialog(contentPanel,
									"Introduce una fecha correcta", "Error",
									JOptionPane.ERROR_MESSAGE);

					}
				});
				okButton.setActionCommand("Aceptar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Comprueba si la matrícula del coche es válida o no
	 * 
	 * @param numSerie
	 *            Representa el número de serie a validar
	 * @return true si el número de serie es válido, false si el número de serie
	 *         no es válido
	 */
	public static boolean esValidaFecha(String fecha) {
		return patternFecha.matcher(fecha).matches();
	}

}
