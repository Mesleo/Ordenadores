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

public class AnnadirSobremesa extends VentanaPrincipal implements Precio{

	Componentes fuentealimentacion;
	Componentes tgrafica;
	Componentes discoDuro;
	Componentes ram;
	Componentes procesador;
	Componentes placa;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AnnadirSobremesa(final TiendaOrdenador almacen) {
		super();
		comboBoxAlimentacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuentealimentacion = (Componentes) comboBoxAlimentacion.getSelectedItem();
				falim = fuentealimentacion.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		comboBoxTgrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tgrafica = (Componentes) comboBoxTgrafica.getSelectedItem();
				tgraf = tgrafica.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		comboBoxDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discoDuro = (Componentes) comboBoxDiscoDuro.getSelectedItem();
				dduro = discoDuro.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		comboBoxRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ram = (Componentes) comboBoxRam.getSelectedItem();
				memoriaram = ram.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		comboBoxProces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesador = (Componentes) comboBoxProces.getSelectedItem();
				proc = procesador.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		comboBoxPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placa = (Componentes) comboBoxPlaca.getSelectedItem();
				plac = placa.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		
		rate = 40f;
		pant = Pantalla.QUINCE.getPrecio();
		lblCalcPrecio.setText(String.valueOf(rate+pant));
		
		radio27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pant = Pantalla.VEINTISIETE.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
		radio21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					pant = Pantalla.VEINTIUNA.getPrecio();
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
			}
		});
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
		
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularPrecio();
			}
		});
		comboBoxModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModelosOrdenador modelo = (ModelosOrdenador) comboBoxModelo.getSelectedItem();
				mod = modelo.getPrecio();
				lblCalcPrecio.setText(String.valueOf(calcularPrecio()));	
			}
		});
		eliminar.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		panelRatonTeclado.setVisible(true);
		setTitle("Añadir ordenador de sobremesa");
		
		comboBoxMarca.setModel(new DefaultComboBoxModel(MarcasOrdenador.getArray(TipoOrdenador.SOBREMESA)));
		comboBoxModelo.setModel(new DefaultComboBoxModel( getModelo(comboBoxMarca)));

		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
					mod = 0;
					comboBoxModelo.setEnabled(false);
					comboBoxPlaca.setEnabled(true);
					if (comboBoxPlaca.getSelectedItem() == Componentes.ASUS){
						plac = Componentes.ASUS.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					comboBoxProces.setEnabled(true);
					if (comboBoxProces.getSelectedItem() == Componentes.AMDFM2){
						proc = Componentes.AMDFM2.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					comboBoxRam.setEnabled(true);
					if (comboBoxRam.getSelectedItem() == Componentes.CUATROGB){
						memoriaram = Componentes.ASUS.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					comboBoxDiscoDuro.setEnabled(true);
					if (comboBoxDiscoDuro.getSelectedItem() == Componentes.QUINIENTOSGB){
						dduro = Componentes.AMDFM2.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					comboBoxTgrafica.setEnabled(true);
					if (comboBoxTgrafica.getSelectedItem() == Componentes.UNGB){
						tgraf = Componentes.ASUS.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					comboBoxAlimentacion.setEnabled(true);
					if (comboBoxAlimentacion.getSelectedItem() == Componentes.CUATROCIENTOS){
						falim = Componentes.AMDFM2.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					precio = rate + plac + proc + memoriaram + dduro + tgraf + falim;
					lblCalcPrecio.setText(String.valueOf(precio));
					comboBoxPlaca.setModel(new DefaultComboBoxModel( Componentes.getArray(CrearPropioOrdenador.PLACABASE)));
					comboBoxProces.setModel(new DefaultComboBoxModel( Componentes.getArray(CrearPropioOrdenador.PROCESADOR)));
					comboBoxRam.setModel(new DefaultComboBoxModel(Componentes.getArray(CrearPropioOrdenador.RAM)));
					comboBoxDiscoDuro.setModel(new DefaultComboBoxModel(Componentes.getArray(CrearPropioOrdenador.DISCODURO)));
					comboBoxTgrafica.setModel(new DefaultComboBoxModel( Componentes.getArray(CrearPropioOrdenador.TARJETAGRAFICA)));
					comboBoxAlimentacion.setModel(new DefaultComboBoxModel( Componentes.getArray(CrearPropioOrdenador.FUENTEALIMENTACION)));
				}
				else if (comboBoxMarca.getSelectedItem() != MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
					plac = 0;
					proc = 0;
					memoriaram = 0;
					dduro = 0;
					tgraf = 0;
					falim = 0;
					comboBoxModelo.setEnabled(true);
					comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
					if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.ASUS){
						mod = ModelosOrdenador.CP6230.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					else if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.SONYVAIO){
						mod = ModelosOrdenador.PAVILION.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					else if (comboBoxMarca.getSelectedItem() == MarcasOrdenador.APPLE){
						mod = ModelosOrdenador.MACMINI.getPrecio();
						lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
					}
					comboBoxPlaca.setEnabled(false);
					comboBoxProces.setEnabled(false);
					comboBoxRam.setEnabled(false);
					comboBoxDiscoDuro.setEnabled(false);
					comboBoxTgrafica.setEnabled(false);
					comboBoxAlimentacion.setEnabled(false);
				}
				
			}
		});
		
		tecladoRatonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tecladoRatonSi.isSelected()){
					rate = 40f;
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
				}
			}
		});
		tecladoRatonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tecladoRatonNo.isSelected()){
					rate = 0f;
					lblCalcPrecio.setText(String.valueOf(calcularPrecio()));
				}
			}
		});
		
		/**
		 * Funcionalidad del botón Añadir
		 */
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMarca.getSelectedItem() != MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
					if (almacen.annadirOrdenador(Sobremesa.instanciarOrdenador(TipoOrdenador.SOBREMESA, 
							textField.getText(), getPantalla(),
							calcularPrecio(),
							(MarcasOrdenador) comboBoxMarca.getSelectedItem(),
							(ModelosOrdenador) comboBoxModelo.getSelectedItem(), 
							getRatonTeclado()))) {
						JOptionPane.showMessageDialog(contentPanel,
								"Ordenador añadido con éxito.", "Mensaje",
								JOptionPane.PLAIN_MESSAGE);
						Generar.setModificado(true);
						Generar.setGuardado(false);
					} else {
						errorAnnadir();
					}
				}else{
					if (almacen.annadirOrdenador(PropioPC.instanciarOrdenador(TipoOrdenador.SOBREMESA, 
							textField.getText(), getPantalla(),
							calcularPrecio(),(MarcasOrdenador) comboBoxMarca.getSelectedItem(), 
							(Componentes)comboBoxPlaca.getSelectedItem(), (Componentes)comboBoxProces.getSelectedItem(),
							(Componentes)comboBoxRam.getSelectedItem(), (Componentes)comboBoxDiscoDuro.getSelectedItem(),
							(Componentes)comboBoxTgrafica.getSelectedItem(), (Componentes)comboBoxAlimentacion.getSelectedItem(),
							getRatonTeclado()))) {
						JOptionPane.showMessageDialog(contentPanel,
								"Ordenador añadido con éxito.", "Mensaje",
								JOptionPane.PLAIN_MESSAGE);
						Generar.setModificado(true);
						Generar.setGuardado(false);
					} else {
						errorAnnadir();
					}
				}
			}
		});
	}


	protected Pantalla getPantalla() {
		if (radio11.isSelected())
			return Pantalla.ONCE;
		if (radio15.isSelected())
			return Pantalla.QUINCE;
		if (radio21.isSelected())
			return Pantalla.VEINTIUNA;
		if (radio27.isSelected())
			return Pantalla.VEINTISIETE;
		return null;
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

	private boolean getRatonTeclado() {
		if (tecladoRatonSi.isSelected())
			return true;
		return false;
	}

	private void errorAnnadir() {
		JOptionPane.showMessageDialog(contentPanel,
				"El ordenador no se ha podido añadir.", "Error",
				JOptionPane.ERROR_MESSAGE);
		Generar.setModificado(false);
	}

	@Override
	public float calcularPrecio() {
		precio = pant + mod + rate + plac + proc + memoriaram + dduro + tgraf + falim;
		return precio;
	}
}