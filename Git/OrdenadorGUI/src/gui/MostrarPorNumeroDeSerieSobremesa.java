package gui;

import javax.swing.JOptionPane;

import ordenadores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPorNumeroDeSerieSobremesa extends Mostrar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TiendaOrdenador almacen2 = new TiendaOrdenador();

	/**
	 * Create the dialog.
	 */
	public MostrarPorNumeroDeSerieSobremesa(final TiendaOrdenador almacen) {
		super(almacen);
		this.almacen = almacen;
		lblModNumSerie.setVisible(false);
		buscar.setVisible(true);
		eliminar.setVisible(false);
		
		textField.setVisible(true);
		setTitle("Mostrar por número de serie");
	
		lblCalcPrecio.setText("0.00");
		lblMarca.setVisible(false);
		lblModMarca.setVisible(false);
		lblModelo.setVisible(false);
		lblModModelo.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordenador ordenador = almacen.get((Ordenador)new Sobremesa(textField.getText()));
				
				if (ordenador != null) {
					mostrarOrdenador(ordenador);
				}
				else {
					JOptionPane.showMessageDialog(contentPanel,
							"No existe ningún ordenador con ese número de serie.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				almacen2 = new TiendaOrdenador();
			}

		});
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
		

}