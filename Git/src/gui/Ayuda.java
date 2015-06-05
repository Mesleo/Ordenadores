package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

/**
 * Clase que muestra una ventana con ayuda sobre el programa
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Ayuda extends JFrame {
	/**
	 * 
	 */
	private JFrame ventana;
	
	private JPanel panel;
	
	private JScrollPane panel_con_barra;
	
	private static final long serialVersionUID = 1L;

	public Ayuda() {
		
		ventana = new JFrame();
		setTitle("Ayuda"); 
		ventana.setBounds(450, 0, 584, 730);
		JEditorPane editorpane = new JEditorPane();
		editorpane.setContentType("text/html");
		editorpane.setText("<h2>TIENDA DE ORDENADORES</h2>\r\n<p>Este programa se encarga de gestionar una "
				+ "tienda de ordenadores, almacenando ordenadores <br/>mediante un n\u00FAmero de serie "
				+ "un\u00EDvoco y con propiedades como: tama\u00F1o de pantalla, marca, modelo, etc.</p>"
				+ "\r\n<p>El n\u00FAmero de serie consistir\u00E1 en 5 car\u00E1cteres alfanum\u00E9ricos: "
				+ "A1B2C.</p><br/><hr/>\r\n\r\n<h2>MANUAL:</h2>\r\n<h3>Archivo</h3>\r\n<ul>\r\n\t<li><strong>"
				+ "NUEVO (CTRL  + N):</strong> Para crear un almac\u00E9n nuevo, en \u00E9l se podr\u00E1n "
				+ "almacenar los <br/>distintos ordenadores con sus respectivas caracter\u00EDsticas.</li>"
				+ "\r\n\t<li><strong>ABRIR (CTRL  + O):</strong> Para abrir un almac\u00E9n guardado "
				+ "previamente en cualquier otro momento.</li>\r\n\t<li><strong>GUARDAR (CTRL  + S):</strong>"
				+ " Para guardar un almac\u00E9nque haya sido creado o modificado.</li>\r\n\t<li><strong>"
				+ "GUARDAR COMO (CTRL  + M):</strong> Para guardar un almac\u00E9n con un nombre "
				+ "espec\u00EDfico.</li>\r\n</ul>\r\n<h3>Tienda ordenadores</h3>\r\n<ul>\r\n\t<li><strong>"
				+ "COMPRAR ORDENADOR\r\n\t\t<ul>\r\n\t\t\t<li>Sobremesa (ALT  + S):</strong> Para comprar "
				+ "un ordenador de sobremesa, ya sea por <br/>marcas y modelo espec\u00EDfico o por componentes."
				+ "</li>\r\n\t\t\t<li>Port\u00E1til (ALT  + P):</strong> Para comprar un ordenador "
				+ "port\u00E1til por marca y modelo.</li>\r\n\t\t</ul>\r\n\t<li><strong>VENDER ORDENADOR"
				+ "\r\n\t\t<ul>\r\n\t\t\t<li>Sobremesa (May\u00FAs  + S):</strong> Para vender un ordenador "
				+ "de sobremesa por n\u00FAmero de serie.</li>\r\n\t\t\t<li>Port\u00E1til (May\u00FAs  + P):"
				+ "</strong> Para vender un ordenador port\u00E1til por n\u00FAmero de serie.</li>\r\n\t"
				+ "\t</ul>\r\n\t<li><strong>Mostrar almac\u00E9n (ALT  + L):</strong> Para mostrar los "
				+ "ordenadores contenidos en el <br/>almac\u00E9n con el que se est\u00E1 trabajando.</li>"
				+ "\r\n\t<li><strong>Total ordenadores (ALT  + T):</strong> Muestra el n\u00FAmero de "
				+ "ordenadores que hay en el almac\u00E9n.</li>\r\n</ul>\r\n<h3>Buscar</h3>\r\n<ul>\r\n\t"
				+ "<li><strong>Por n\u00FAmero de serie (ALT GR  + S):</strong> Busca ordenarores por "
				+ "n\u00FAmero de serie.</li>\r\n\t<li><strong>Por fecha de compra (ALT GR + C):</strong> "
				+ "Busca ordenadores por fecha de compra.</li>\r\n</ul>\r\n<h3>Ayuda</h3>\r\n<ul>\r\n\t<li>"
				+ "<strong>Ayuda (CTRL + May\u00FAs  + H):</strong> Muestra ayuda sobre el programa Tienda "
				+ "Ordenadores.</li>\r\n\t<li><strong>Sobre Tienda Ordenadores (CTRL + May\u00FAs  + C):"
				+ "</strong> Muestra informaci\u00F3n sobre <br/>el programa: versi\u00F3n, autor, etc.</li>\r\n</ul>");
		
		panel = new JPanel();
		
		getContentPane().add(editorpane);
		panel.add(editorpane);
		panel_con_barra = new JScrollPane(panel); 
		ventana.setContentPane(panel_con_barra);
		ventana.setVisible(true);
	}
}
