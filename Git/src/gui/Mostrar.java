package gui;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 * Clase que muestra los ordenadores del almacén
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Mostrar extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected TiendaOrdenador almacen;
	private int indiceOrdenador = -1;
	
	protected JLabel tfRaton;
	protected JLabel labelRatonTeclado;
	protected JLabel tfRatonTeclado;
	protected JLabel lblMaletin;
	protected JLabel tfMaletin;
	protected JLabel lblRaton;
	protected JLabel lblPropioPC;
	protected JLabel lblModPlaca;
	protected String string;
	protected JLabel lblModProces;
	protected JLabel lblModRam;
	protected JLabel lblModDiscoDuro;
	protected JLabel lblModTgrafica;
	protected JLabel lblModAlimentacion;
	protected JLabel lblModNumSerie;
	protected JLabel lblModMarca;
	protected JLabel lblModModelo;
	

	/**
	 * Constructor de la ventana Mostrar
	 * 
	 * @param almacen Almacén de TiendaOrdenador
	 */
	public Mostrar(TiendaOrdenador almacen) {
		super();
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
		this.almacen = almacen;
	
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
			Generar.setModificado(true);
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
		if (almacen.size() == 1){
			buttonAnterior.setVisible(false);
			buttonSiguiente.setVisible(false);
		}
		lblModPantalla.setText(ordenador.getPantalla().getPulgadas());
		lblFechaCompra.setText(ordenador.getFechaCompra());
		if (ordenador.getMarca() == MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
			actualizarPropioPC(ordenador);
		}
		if (ordenador.getTipo() == TipoOrdenador.SOBREMESA && ordenador.getMarca() != MarcasOrdenador.CREAR_MI_PROPIO_ORDENADOR){
			actualizarSobremesa(ordenador);
		}
		if (ordenador.getTipo() == TipoOrdenador.PORTATIL){
			actualizarPortatil(ordenador);
		}
		setTitle(String.valueOf(ordenador.getTipo()));
	}

	void actualizarPortatil(Ordenador ordenador) {
		Portatil portatil = (Portatil) ordenador;
		string = portatil.getNumSerie();
		actualizarNumeroSerie(string);
		lblCalcPrecio.setText(String.valueOf(portatil.calcularPrecio()));
		especificSobremesa(portatil, false, true);
		lblPropioPC.setVisible(false);
		//Portatil cambia todos los valores a true
		cambiarBooleanoDeSobremesa(true);
		lblModMarca.setText(String.valueOf(portatil.getMarcasportatil()));
		lblModModelo.setText(String.valueOf(portatil.getModelo()));
		//Portatil cambia todos los valores a false
		cambiarBooleanoDePropioPC(false);
		if (portatil.isRaton()== false)
			tfRaton.setText("No");
		else
			tfRaton.setText("Si");
		if (portatil.isMaletin() == false)
			tfMaletin.setText("No");
		else
			tfMaletin.setText("Si");
	}

	void actualizarSobremesa(Ordenador ordenador) {
		Sobremesa sobremesa = (Sobremesa)ordenador;
		string = sobremesa.getNumSerie();
		lblCalcPrecio.setText(String.valueOf(sobremesa.calcularPrecio()));
		actualizarNumeroSerie(string);
		if (sobremesa.isRaton_teclado() == false)
			tfRatonTeclado.setText("No");
		else
			tfRatonTeclado.setText("Si");
		lblPropioPC.setVisible(false);
		especificSobremesa(sobremesa, true, false);
		
		//Sobremesa cambia todos los valores a true
		cambiarBooleanoDeSobremesa(true);
		lblModMarca.getText();
		lblModMarca.setText(String.valueOf(sobremesa.getMarca()));
		lblModModelo.setText(String.valueOf(sobremesa.getModelo()));
		
		//Sobremesa cambia todos los valores a false
		cambiarBooleanoDePropioPC(false);
	}

	void actualizarPropioPC(Ordenador ordenador) {
		PropioPC pc = (PropioPC) ordenador;
		string = pc.getNumSerie();
		actualizarNumeroSerie(string);
		lblCalcPrecio.setText(String.valueOf(pc.calcularPrecio()));
		if (pc.isRaton_teclado() == false)
			tfRatonTeclado.setText("No");
		else
			tfRatonTeclado.setText("Si");
		especificSobremesa(pc,true,false);
		
		//PropioPC cambia todos los valores a false
		cambiarBooleanoDeSobremesa(false);
		
		//PropioPC cambia todos los valores a true
		cambiarBooleanoDePropioPC(true);
		
		lblPropioPC.setText("Crear mi propio PC");
		lblModPlaca.setText(String.valueOf(pc.getPlaca()));
		lblModProces.setText(String.valueOf(pc.getProcesador()));
		lblModRam.setText(String.valueOf(pc.getRam()));
		lblModDiscoDuro.setText(String.valueOf(pc.getDiscoDuro()));
		lblModTgrafica.setText(String.valueOf(pc.getTarjetaGrafica()));
		lblModAlimentacion.setText(String.valueOf(pc.getFuenteAlimentacion()));
	}

	private void cambiarBooleanoDeSobremesa(boolean b) {
		lblMarca.setVisible(b);
		lblModMarca.setVisible(b);
		lblModelo.setVisible(b);
		lblModModelo.setVisible(b);
	}

	private void cambiarBooleanoDePropioPC(boolean b) {
		lblPropioPC.setVisible(b);
		lblModPlaca.setVisible(b);
		lblPlaca.setVisible(b);
		lblModPlaca.setVisible(b);
		lblProcesador.setVisible(b);
		lblModProces.setVisible(b);
		lblRam.setVisible(b);
		lblModRam.setVisible(b);
		lblDiscoDuro.setVisible(b);
		lblModDiscoDuro.setVisible(b);
		lblTarjetaGrfica.setVisible(b);
		lblModTgrafica.setVisible(b);
		lblFuenteAlimentacin.setVisible(b);
		lblModAlimentacion.setVisible(b);
		
	}

	private void especificSobremesa(Ordenador ordenador, boolean b, boolean b2) {
		labelRatonTeclado.setVisible(b);
		tfRatonTeclado.setVisible(b);
		lblRaton.setVisible(b2);
		tfRaton.setVisible(b2);
		lblMaletin.setVisible(b2);
		tfMaletin.setVisible(b2);
	}
	
	private void actualizarNumeroSerie(String string){
		lblModNumSerie.setText(string);
	}
	
	private void comprobarBotones() {
		if (almacen.get(indiceOrdenador + 1) == null)
			buttonSiguiente.setVisible(false);
		else
			buttonSiguiente.setVisible(true);

		if (almacen.get(indiceOrdenador - 1) == null)
			buttonAnterior.setVisible(false);
		else
			buttonAnterior.setVisible(true);
	}
}