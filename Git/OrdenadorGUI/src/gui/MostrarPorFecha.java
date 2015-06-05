package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import ordenadores.Ordenador;
import ordenadores.Sobremesa;
import ordenadores.TiendaOrdenador;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MostrarPorFecha extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TiendaOrdenador almacen;
	private int indiceOrdenador = -1;
	private JTextField tfFecha;

	private JLabel tfRaton;
	private JLabel labelRatonTeclado;
	private JLabel tfRatonTeclado;
	private JLabel lblMaletin;
	private JLabel tfMaletin;
	private JLabel lblRaton;
	private JLabel lblPropioPC;
	private JLabel lblModPlaca;
	private String string;
	private JLabel lblModProces;
	private JLabel lblModRam;
	private JLabel lblModDiscoDuro;
	private JLabel lblModTgrafica;
	private JLabel lblModAlimentacion;
	private JLabel lblModNumSerie;
	private JLabel lblModMarca;
	private JLabel lblModModelo;

	/**
	 * Create the dialog.
	 */
	public MostrarPorFecha(ArrayList<Ordenador> almacen) {
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		setTitle("Mostrar tienda");
		this.almacen = generarAlmacen(almacen);
	
		textField.setVisible(false);
		annadir.setVisible(false);
		buscar.setVisible(false);
		comboBoxMarca.setVisible(false);
		comboBoxModelo.setVisible(false);
		comboBoxAlimentacion.setVisible(false);
		comboBoxPlaca.setVisible(false);
		comboBoxProces.setVisible(false);
		comboBoxRam.setVisible(false);
		comboBoxDiscoDuro.setVisible(false);
		comboBoxTgrafica.setVisible(false);
		radio11.setVisible(false);
		radio15.setVisible(false);
		radio21.setVisible(false);
		radio27.setVisible(false);
		lblCalcPrecio.setBounds(131, 437, 65, 14);
		getContentPane().add(lblCalcPrecio);
		lblFechaCompra = new JLabel();
		lblFechaCompra.setBounds(402, 402, 90, 14);
		getContentPane().add(lblFechaCompra);
		getContentPane().add(buttonAnterior);	
		getContentPane().add(buttonAnterior);
		
		tfRaton = new JLabel();
		tfRaton.setBounds(386, 47, 62, 20);
		getContentPane().add(tfRaton);
		
		labelRatonTeclado = new JLabel("Rat\u00F3n y teclado:");
		labelRatonTeclado.setBounds(347, 19, 101, 14);
		getContentPane().add(labelRatonTeclado);
		
		tfRatonTeclado = new JLabel();
		tfRatonTeclado.setBounds(386, 46, 62, 20);
		getContentPane().add(tfRatonTeclado);
		
		lblMaletin = new JLabel("Malet\u00EDn:");
		lblMaletin.setBounds(347, 86, 62, 14);
		getContentPane().add(lblMaletin);
		
		tfMaletin = new JLabel();
		tfMaletin.setBounds(386, 112, 62, 20);
		getContentPane().add(tfMaletin);
		
		lblRaton = new JLabel("Rat\u00F3n:");
		lblRaton.setBounds(347, 19, 62, 14);
		getContentPane().add(lblRaton);
		
		lblPropioPC = new JLabel("New label");
		lblPropioPC.setBounds(26, 82, 185, 23);
		getContentPane().add(lblPropioPC);
		
		lblModPlaca = new JLabel("New label");
		lblModPlaca.setBounds(92, 212, 119, 17);
		getContentPane().add(lblModPlaca);
		
		lblModProces = new JLabel("New label");
		lblModProces.setBounds(92, 274, 119, 17);
		getContentPane().add(lblModProces);
		
		lblModRam = new JLabel("New label");
		lblModRam.setBounds(92, 335, 119, 17);
		getContentPane().add(lblModRam);
		
		lblModDiscoDuro = new JLabel("New label");
		lblModDiscoDuro.setBounds(339, 212, 109, 17);
		getContentPane().add(lblModDiscoDuro);
		
		lblModTgrafica = new JLabel("New label");
		lblModTgrafica.setBounds(339, 274, 109, 17);
		getContentPane().add(lblModTgrafica);
		
		lblModAlimentacion = new JLabel("New label");
		lblModAlimentacion.setBounds(339, 335, 109, 17);
		getContentPane().add(lblModAlimentacion);
		
		lblModNumSerie = new JLabel("New label");
		lblModNumSerie.setBounds(92, 19, 101, 14);
		getContentPane().add(lblModNumSerie);
		
		lblModMarca = new JLabel("New label");
		lblModMarca.setBounds(96, 82, 107, 14);
		getContentPane().add(lblModMarca);
		
		lblModModelo = new JLabel("New label");
		lblModModelo.setBounds(92, 144, 101, 14);
		getContentPane().add(lblModModelo);
		
		lblModPantalla = new JLabel("New label");
		lblModPantalla.setBounds(10, 20, 105, 14);
		panelPantalla.add(lblModPantalla);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(180, 437, 18, 14);
		getContentPane().add(label);
	
		
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

	protected void eliminar() {
		int n = JOptionPane.showOptionDialog(contentPanel,
				"¿Estás seguro?", "Eliminar",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (n == JOptionPane.NO_OPTION)
			return;
		else if (n == JOptionPane.YES_OPTION){
			almacen.eliminar(almacen.get(indiceOrdenador));
			actualizar();
			if (almacen.size() == 0){
				JOptionPane.showMessageDialog(null, "Ya no hay ordenadores en el almacén");
				setVisible(false);
			}
		}
	}

	void actualizar() {
		if (almacen.size() == 0) {
			return;
		}
		indiceOrdenador = 0;
		mostrarOrdenador(almacen.get(indiceOrdenador));
		comprobarBotones();		
	}
	
	void actualizarBuscados(TiendaOrdenador almacen2) {
		if (almacen.size() == 0) {
			return;
		}
		indiceOrdenador = 0;
		mostrarOrdenador(almacen2.get(indiceOrdenador));
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
	
	void mostrarOrdenador(Ordenador ordenador) {
		ArrayList<Ordenador> arrOrdenadoresFecha = new ArrayList<Ordenador>();
		for (Ordenador ordenador2 : arrOrdenadoresFecha) {
			
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
	
	private TiendaOrdenador generarAlmacen(ArrayList<Ordenador> almacen) {
		TiendaOrdenador almacenPorFecha = new TiendaOrdenador();
		for (Ordenador ordenador : almacen) {
			almacenPorFecha.annadirOrdenador(ordenador);
		}
		return almacenPorFecha;
	}
}