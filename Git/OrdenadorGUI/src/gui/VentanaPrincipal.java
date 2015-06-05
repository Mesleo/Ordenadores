package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ordenadores.*;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VentanaPrincipal extends JDialog implements Precio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JComboBox<MarcasOrdenador> comboBoxMarca;
	protected JComboBox<ModelosOrdenador> comboBoxModelo;
	protected JButton annadir;
	protected JButton eliminar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton buscar;
	protected JButton salir;	
	protected JComboBox<Componentes> comboBoxPlaca;
	protected JComboBox<Componentes> comboBoxProces;
	protected JComboBox<Componentes> comboBoxRam;
	protected JComboBox<Componentes> comboBoxDiscoDuro;
	protected JComboBox<Componentes> comboBoxTgrafica;
	protected JComboBox<Componentes> comboBoxAlimentacion;
	protected JLabel lblModPantalla;
	protected JLabel lblPlaca;
	protected JLabel lblProcesador;
	protected JLabel lblRam;
	protected JLabel lblDiscoDuro;
	protected JLabel lblTarjetaGrfica;
	protected JLabel lblFuenteAlimentacin;
	protected JLabel lblPrecio;
	protected JLabel lblCalcPrecio;
	protected JLabel lblFechaCompra;

	/**
	 * Grupo pantalla
	 */
	protected ButtonGroup grupoPantalla = new ButtonGroup();
	protected JPanel panelPantalla;
	protected JRadioButton radio11;
	protected JRadioButton radio15;
	protected JRadioButton radio21;
	protected JRadioButton radio27;	
	
	/**
	 * Grupo ratón teclado
	 */
	protected ButtonGroup grupoTecladoRaton = new ButtonGroup();
	protected JPanel panelRatonTeclado;
	protected JRadioButton tecladoRatonSi;
	protected JRadioButton tecladoRatonNo;
	
	/**
	 * Grupo ratón
	 */
	protected ButtonGroup grupoRaton = new ButtonGroup();
	protected JPanel panelRaton;
	protected JRadioButton ratonSi;
	protected JRadioButton ratonNo;
	
	/**
	 * Grupo maletín
	 */
	protected ButtonGroup grupoMaletin = new ButtonGroup();
	protected JPanel panelMaletin;
	protected JRadioButton maletinSi;
	protected JRadioButton maletinNo;

	protected static float precio = 0;
	protected static float pant = 0;
	protected static float mod = 0;
	protected static float rate = 0;
	protected static float r = 0;
	protected static float mal = 0;
	protected static float plac;
	protected static float proc;
	protected static float memoriaram;
	protected static float dduro;
	protected static float tgraf;
	protected static float falim;
	
	private Calendar calendario = GregorianCalendar.getInstance();
	private Date fecha = calendario.getTime();
	private SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
	protected String fechaActual = formatoDeFecha.format(fecha);
	
	public VentanaPrincipal() {
		super();
		setResizable(false);
		setModal(true);
		
		setBounds(250, 180, 500, 500);
		setLocationRelativeTo(null);
		
		buttonAnterior = new JButton();
		setBackground(Color.blue);
		buttonSiguiente = new JButton();
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonSiguiente.setIcon(new ImageIcon("src/imagenes/flechadcha.png"));
		getContentPane().add(buttonSiguiente);
		buttonSiguiente.setBounds(267, 437, 50, 23);
		getContentPane().add(buttonSiguiente);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(26, 82, 49, 14);
		getContentPane().add(lblMarca);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(26, 144, 49, 14);
		getContentPane().add(lblModelo);
		lblMatricula = new JLabel("N\u00BA Serie:");
		lblMatricula.setBounds(26, 11, 76, 30);
		getContentPane().add(lblMatricula);
		
		annadir = new JButton("A\u00F1adir");
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		annadir.setBounds(323, 437, 86, 23);
		
		getContentPane().add(annadir);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(323, 437, 86, 23);
		getContentPane().add(eliminar);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(323, 437, 86, 23);
		getContentPane().add(buscar);
		
		salir = new JButton("Salir");
		salir.setBounds(419, 437, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		getContentPane().add(salir);
		
		comboBoxMarca = new JComboBox<MarcasOrdenador>();
		comboBoxMarca.setBounds(92, 78, 101, 22);
		getContentPane().add(comboBoxMarca);
		
		comboBoxModelo = new JComboBox<ModelosOrdenador>();
		comboBoxModelo.setBounds(92, 140, 101, 22);
		getContentPane().add(comboBoxModelo);
		
		textField = new JTextField();
		textField.setToolTipText("El número de serie debe tener 5 carácteres alfanuméricos");
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!Ordenador.esValido(textField.getText()))
					textField.setForeground(java.awt.Color.RED);
				else
					textField.setForeground(Color.black);
			}
		});
		textField.setBounds(92, 16, 102, 20);
		textField.setColumns(10);
		getContentPane().add(textField);
		
		panelPantalla = new JPanel();
		panelPantalla.setForeground(new Color(0, 0, 0));
		panelPantalla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tama\u00F1o pantalla", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPantalla.setBounds(208, 19, 121, 126);
		getContentPane().add(panelPantalla);
		panelPantalla.setLayout(null);
		
		radio11 = new JRadioButton("11 \"");
		radio11.setBounds(6, 16, 109, 23);
		grupoPantalla.add(radio11);
		panelPantalla.add(radio11);
		
		radio15 = new JRadioButton("15 \"");
		radio15.setSelected(true);
		radio15.setBounds(6, 44, 109, 23);
		grupoPantalla.add(radio15);
		panelPantalla.add(radio15);
		
		radio21 = new JRadioButton("21 \"");
		radio21.setBounds(6, 70, 109, 23);
		grupoPantalla.add(radio21);
		panelPantalla.add(radio21);		
		
		radio27 = new JRadioButton("27 \"");
		radio27.setBounds(6, 96, 109, 23);
		grupoPantalla.add(radio27);
		panelPantalla.add(radio27);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(26, 437, 46, 14);
		getContentPane().add(lblPrecio);
		
		comboBoxPlaca = new JComboBox<Componentes>();
		comboBoxPlaca.setBounds(92, 209, 101, 20);
		getContentPane().add(comboBoxPlaca);
		
		lblPlaca = new JLabel("Placa base:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPlaca.setBounds(26, 212, 65, 14);
		getContentPane().add(lblPlaca);
		
		comboBoxProces = new JComboBox<Componentes>();
		comboBoxProces.setBounds(92, 271, 101, 20);
		getContentPane().add(comboBoxProces);
		
		comboBoxRam = new JComboBox<Componentes>();
		comboBoxRam.setBounds(92, 332, 101, 20);
		getContentPane().add(comboBoxRam);
		
		comboBoxDiscoDuro = new JComboBox<Componentes>();
		comboBoxDiscoDuro.setBounds(339, 209, 109, 20);
		getContentPane().add(comboBoxDiscoDuro);
		
		comboBoxTgrafica = new JComboBox<Componentes>();
		comboBoxTgrafica.setBounds(339, 271, 109, 20);
		getContentPane().add(comboBoxTgrafica);
		
		comboBoxAlimentacion = new JComboBox<Componentes>();
		comboBoxAlimentacion.setBounds(339, 332, 109, 20);
		getContentPane().add(comboBoxAlimentacion);
		
		lblProcesador = new JLabel("Procesador: ");
		lblProcesador.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblProcesador.setBounds(26, 274, 76, 14);
		getContentPane().add(lblProcesador);
		
		lblRam = new JLabel("RAM:");
		lblRam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRam.setBounds(26, 335, 65, 14);
		getContentPane().add(lblRam);
		
		lblDiscoDuro = new JLabel("Disco duro:");
		lblDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiscoDuro.setBounds(241, 212, 72, 14);
		getContentPane().add(lblDiscoDuro);
		
		lblTarjetaGrfica = new JLabel("Tarjeta gr\u00E1fica:");
		lblTarjetaGrfica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTarjetaGrfica.setBounds(241, 274, 76, 14);
		getContentPane().add(lblTarjetaGrfica);
		
		lblFuenteAlimentacin = new JLabel("Alimentaci\u00F3n (W):\r\n\r\n");
		lblFuenteAlimentacin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFuenteAlimentacin.setBounds(241, 335, 88, 14);
		getContentPane().add(lblFuenteAlimentacin);
		
		panelRatonTeclado = new JPanel();
		panelRatonTeclado.setVisible(false);
		panelRatonTeclado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Teclado y rat\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRatonTeclado.setBounds(346, 19, 121, 72);
		getContentPane().add(panelRatonTeclado);
		panelRatonTeclado.setLayout(null);
		
		tecladoRatonSi = new JRadioButton("Si");
		tecladoRatonSi.setBounds(6, 16, 109, 23);
		panelRatonTeclado.add(tecladoRatonSi);
		tecladoRatonSi.setSelected(true);
		grupoTecladoRaton.add(tecladoRatonSi);
		
		tecladoRatonNo = new JRadioButton("No");
		tecladoRatonNo.setBounds(6, 42, 109, 23);
		panelRatonTeclado.add(tecladoRatonNo);
		grupoTecladoRaton.add(tecladoRatonNo);
		
		panelRaton = new JPanel();
		panelRaton.setVisible(false);
		panelRaton.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rat\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRaton.setBounds(347, 19, 121, 72);
		getContentPane().add(panelRaton);
		panelRaton.setLayout(null);
		
		ratonSi = new JRadioButton("Si");
		ratonSi.setBounds(6, 16, 109, 23);
		panelRaton.add(ratonSi);
		grupoRaton.add(ratonSi);
		
		ratonNo = new JRadioButton("No");
		ratonNo.setBounds(6, 42, 109, 23);
		panelRaton.add(ratonNo);
		ratonNo.setSelected(true);
		grupoRaton.add(ratonNo);
		
		panelMaletin = new JPanel();
		panelMaletin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Malet\u00EDn:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMaletin.setBounds(347, 102, 121, 72);
		panelMaletin.setVisible(false);
		getContentPane().add(panelMaletin);
		panelMaletin.setLayout(null);
		
		maletinSi = new JRadioButton("Si");
		maletinSi.setBounds(6, 16, 109, 23);
		panelMaletin.add(maletinSi);
		grupoMaletin.add(maletinSi);
		
		maletinNo = new JRadioButton("No");
		maletinNo.setBounds(6, 42, 109, 23);
		panelMaletin.add(maletinNo);
		maletinNo.setSelected(true);
		grupoMaletin.add(maletinNo);
		
		lblFechaCompra = new JLabel();
		lblFechaCompra.setBounds(402, 402, 90, 14);
		getContentPane().add(lblFechaCompra);
		
		lblCalcPrecio = new JLabel("0.00");
		lblCalcPrecio.setBounds(131, 437, 65, 14);
		getContentPane().add(lblCalcPrecio);
		buttonAnterior.setIcon(new ImageIcon("src/imagenes/flechaizda.png"));
		getContentPane().add(buttonAnterior);
		buttonAnterior.setBounds(208, 437, 53, 23);		
		
		getContentPane().setLayout(null);
		getContentPane().add(buttonAnterior);
				
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	@Override
	public float calcularPrecio() {
		return 0;
	}
}