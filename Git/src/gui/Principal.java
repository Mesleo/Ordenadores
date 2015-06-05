package gui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import ordenadores.TiendaOrdenador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase Principal desde donde se ejecutan todas las ventanas gráficas
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Principal {

	protected static JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnOrdenador;
	private JMenu mnBuscar;
	private JMenu mnAyuda;
	protected static TiendaOrdenador almacen = new TiendaOrdenador();
	private Mostrar mostrar;
	private Fecha fecha;
	private MostrarPorNumeroDeSerieSobremesa mostrarpornumserie;
	private About about;
	private Ayuda ayuda;
	private TotalOrdenadores tc;
	boolean ventanaabierta;
	private MostrarPorNumeroDeSerieComponentes mostrarpornumseriepropiopc;
	private MostrarPorNumeroDeSeriePortatil mostrarpornumserieportatil;
	protected static final Component parent = null;
	protected static File file = new File("SinTitulo.obj");
	private final static String message = "Error, no se ha podido hacer la operación con el archivo";
	

	/**
	 * Ejecuta la aplicación
	 * @param args Argumentos por defecto
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, message);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					Generar.salir();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, message);
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, message);
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.setTitle(file.getName());
		frame.setIconImage(new ImageIcon("imagenes/pc.png").getImage()); 
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.comprobarGuardadoNuevo();
					file = new File("SinTitulo.obj");
					frame.setTitle(file.getName());
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
				}
			}
		});
		mntmNuevoConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevoConcesionario);
		
		final JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir...");
		mntmAbrirConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				try {
					try {
						Generar.comprobarGuardadoAbrir();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, message);
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, message);
					}
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, message);
				}
			 }
		});

		
		mnArchivo.add(mntmAbrirConcesionario);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.guardar();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
				}
			}
		});
		
		
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.guardarComo();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
				}
			}
		}
	);
		
		
		mnArchivo.add(mntmGuardarComo);
		
		mnArchivo.addSeparator();
		
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.salir();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
				}
			}
		});
		mnArchivo.add(mntmSalir);
		
		mnOrdenador = new JMenu("Tienda ordenadores");
		menuBar.add(mnOrdenador);
	
		
		JMenu mnComprar = new JMenu("Comprar ordenador");
		mnOrdenador.add(mnComprar);
		
		JMenuItem mntmSobremesa = new JMenuItem("Sobremesa");
		mntmSobremesa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mntmSobremesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Generar.annadirSobremesa(almacen);
			}
		});
		mnComprar.add(mntmSobremesa);
		
		JMenuItem mntmPortatil = new JMenuItem("Portatil");
		mntmPortatil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		mntmPortatil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generar.annadirPortatil(almacen);
			}
		});
		mnComprar.add(mntmPortatil);
		
		mnOrdenador.addSeparator();
		
		JMenuItem mntmMostrarAlmacen = new JMenuItem("Mostrar almac\u00E9n");
		mntmMostrarAlmacen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mntmMostrarAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		mnOrdenador.add(mntmMostrarAlmacen);
		
		JMenuItem mntmMostrarTotalCoches = new JMenuItem("Total ordenadores");
		mntmMostrarTotalCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostarTotal();
			}
		});
		mntmMostrarTotalCoches.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		mnOrdenador.add(mntmMostrarTotalCoches);
		
		mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmCochePorColor = new JMenuItem("Por fecha de compra...");
		mntmCochePorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_GRAPH_MASK));
		mntmCochePorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorFecha();
			}
		});
		
		JMenu mnPorNmeroDe = new JMenu("Por n\u00FAmero de serie");
		mnBuscar.add(mnPorNmeroDe);
		
		JMenu mnSobremesa = new JMenu("Sobremesa");
		mnPorNmeroDe.add(mnSobremesa);
		
		JMenuItem mntmDeSerie = new JMenuItem("De serie");
		mntmDeSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPorNumSerieSobremesa();
			}
		});
		mnSobremesa.add(mntmDeSerie);
		
		JMenuItem mntmPorComponentes = new JMenuItem("Por componentes");
		mntmPorComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPorNumSeriePropioPC();
			}
		});
		mnSobremesa.add(mntmPorComponentes);
		
		JMenuItem mntmPortatil_1 = new JMenuItem("Portatil");
		mntmPortatil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPorNumSeriePortatil();
			}
		});
		mnPorNmeroDe.add(mntmPortatil_1);
		mnBuscar.add(mntmCochePorColor);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarVentanaAbierta();
				
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmSobreConcesionario = new JMenuItem("Sobre TiendaOrdenadores");
		mntmSobreConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmSobreConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = new About();
				about.setVisible(true);
			}
		});
		mnAyuda.add(mntmSobreConcesionario);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/fondoPrincipal.png")));
		lblFondo.setBounds(0, 0, 444, 251);
		frame.getContentPane().add(lblFondo);
		
	}

	protected void comprobarVentanaAbierta() {
		if (!ventanaabierta){
			ayuda = new Ayuda();
			ayuda.setVisible(true);
			ventanaabierta = true;
			return;
		}
		else if (ventanaabierta = true){
			ayuda.setVisible(true);
			return;
		}
	}

	private void mostrar() {
		if (almacen.size() == 0) {
			almacenVacio();
		}else{
			mostrar = new Mostrar(almacen);
			mostrar.setVisible(true);
		}
	}

	private void almacenVacio() {
		JOptionPane.showMessageDialog(frame.getContentPane(),
				"No hay ordenadores en el almacén.", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	private void mostrarPorFecha() {
		if (almacen.size() == 0) {
			almacenVacio();
			return;
		}
		fecha = new Fecha(almacen);
		fecha.setVisible(true);
	}
	
	private void mostrarPorNumSerieSobremesa() {
		if (almacen.size() == 0) {
			almacenVacio();
			return;
		}
		mostrarpornumserie = new MostrarPorNumeroDeSerieSobremesa(almacen);
		mostrarpornumserie.setVisible(true);
	}
	
	private void mostrarPorNumSeriePropioPC() {
		if (almacen.size() == 0) {
			almacenVacio();
			return;
		}
		mostrarpornumseriepropiopc = new MostrarPorNumeroDeSerieComponentes(almacen);
		mostrarpornumseriepropiopc.setVisible(true);		
	}

	private void mostrarPorNumSeriePortatil() {
		if (almacen.size() == 0) {
			almacenVacio();
			return;
		}
		mostrarpornumserieportatil = new MostrarPorNumeroDeSeriePortatil(almacen);
		mostrarpornumserieportatil.setVisible(true);		
	}
	
	private void mostarTotal() {
		tc = new TotalOrdenadores(almacen);
		tc.setVisible(true);
	}
}
		