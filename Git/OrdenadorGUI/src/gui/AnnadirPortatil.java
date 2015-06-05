package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnnadirPortatil extends VentanaPrincipal implements Precio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TipoOrdenador tipo;
	
	/**
	 * Create the dialog.
	 */
	public AnnadirPortatil(final TiendaOrdenador almacen) {
		super();
		lblFechaCompra = new JLabel(fechaActual);
		lblFechaCompra.setBounds(350, 200, 117, 16);
		comboBoxDiscoDuro.setLocation(339, 185);
		comboBoxModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelosOrdenador modelo = (ModelosOrdenador) comboBoxModelo.getSelectedItem();
				mod = modelo.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));	
			}
		});
		
		pant = Pantalla.QUINCE.getPrecio();
		radio15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pant = Pantalla.QUINCE.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		radio11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pant = Pantalla.ONCE.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		
		setTitle("Añadir ordenador portátil");
		
		eliminar.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		panelRaton.setVisible(true);
		panelMaletin.setVisible(true);
		setBounds(250, 180, 500, 300);
		lblPrecio.setBounds(120, 237, 86, 23);
		lblCalcPrecio.setBounds(180, 237, 86, 23);
		annadir.setBounds(323, 237, 86, 23);
		salir.setBounds(419, 237, 65, 23);
		radio21.setVisible(false);
		radio27.setVisible(false);
		panelPantalla.setBounds(216, 19, 121, 72);

		comboBoxPlaca.setVisible(false);
		comboBoxProces.setVisible(false);
		comboBoxRam.setVisible(false);
		comboBoxDiscoDuro.setVisible(false);
		comboBoxTgrafica.setVisible(false);
		comboBoxAlimentacion.setVisible(false);
		lblPlaca.setVisible(false);
		lblProcesador.setVisible(false);
		lblRam.setVisible(false);
		lblDiscoDuro.setVisible(false);
		lblTarjetaGrfica.setVisible(false);
		lblFuenteAlimentacin.setVisible(false);
	
		comboBoxMarca.setModel(new DefaultComboBoxModel(MarcasOrdenador.getArray(TipoOrdenador.PORTATIL)));
		comboBoxModelo.setModel(new DefaultComboBoxModel(
				getModelo(comboBoxMarca)));


		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(
						getModelo(comboBoxMarca)));
			}
		});
		
		ratonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ratonSi.isSelected()){
					r = 15f;
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
				}
			}
		});
		ratonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ratonNo.isSelected()){
					r = 0f;
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
				}
			}
		});
		
		maletinSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (maletinSi.isSelected()){
					mal = 25f;
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
				}
			}
		});
		maletinNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (maletinNo.isSelected()){
					mal = 0f;
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
				}
			}
		});
		
		/**
		 * Funcionalidad del botón Añadir
		 */
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (almacen.annadirOrdenador(Portatil.instanciarOrdenador(TipoOrdenador.PORTATIL,
							textField.getText(), 
							getPantalla(), calcularPrecio(),
							(MarcasOrdenador) comboBoxMarca.getSelectedItem(),
							(ModelosOrdenador) comboBoxModelo.getSelectedItem(),
							getRaton(),getMaletin()))) {
						if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.ASUS_PORTATIL){
							mod = ModelosOrdenador.X205TA.getPrecio();
							lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
						}
						else if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.TOSHIBA){
							mod = ModelosOrdenador.SATELLITEB100.getPrecio();
							lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
						}							
						else if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.SONYVAIO_PORTATIL){
							mod = ModelosOrdenador.SVF1521.getPrecio();
							lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
						}
						else if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.APPLE){
							mod = ModelosOrdenador.MACBOOKAIR.getPrecio();
							lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
						}
						JOptionPane.showMessageDialog(contentPanel,
								"Ordenador añadido con éxito.", "Mensaje",
								JOptionPane.PLAIN_MESSAGE);
						Generar.setModificado(true);
						Generar.setGuardado(false);
					} else {
						JOptionPane.showMessageDialog(contentPanel,
								"El ordenador no se ha podido añadir.", "Error",
								JOptionPane.ERROR_MESSAGE);
						Generar.setModificado(false);
					}
			}
		});
	}
	

	private Object[] getModelo(JComboBox<MarcasOrdenador> comboBoxMarca) {
		MarcasOrdenador marca = (MarcasOrdenador) comboBoxMarca
				.getSelectedItem();
		ArrayList<ModelosOrdenador> modelos = new ArrayList<ModelosOrdenador>();
		for (ModelosOrdenador m : ModelosOrdenador.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}


	private Object[] getMarca(JComboBox<TipoOrdenador> comboBoxTipo) {
		TipoOrdenador tipoordenador = (TipoOrdenador) comboBoxTipo
				.getSelectedItem();
		ArrayList<MarcasOrdenador> modelos = new ArrayList<MarcasOrdenador>();
		for (MarcasOrdenador m : MarcasOrdenador.values()) {
			if (m.getTipo() == tipoordenador)
				modelos.add(m);
		}
		return modelos.toArray();
	}
	

	private boolean getMaletin() {
		if (maletinSi.isSelected())
			return true;
		else
			return false;
	}

	private boolean getRaton() {
		if (ratonSi.isSelected())
			return true;
		else
			return false;
	}
	

	private Pantalla getPantalla() {
		if (radio11.isSelected())
			return Pantalla.ONCE;
		else if (radio15.isSelected())
			return Pantalla.QUINCE;
		else if (radio21.isSelected())
			return Pantalla.VEINTIUNA;
		else if (radio27.isSelected())
			return Pantalla.VEINTISIETE;
		else
			return null;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	@Override
	public float calcularPrecio(){
		precio = pant + mod + r + mal;
		return precio;		
	}
	
}