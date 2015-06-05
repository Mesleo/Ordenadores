package gui;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import ordenadores.TiendaOrdenador;
import ficheros.*;

import java.io.IOException;

/**
 * Clase que se encarga de la gestión de abrir y cerrar ficheros
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Generar extends Principal{

	private static AnnadirSobremesa alta;
	private static boolean modificado = false;
	private static boolean guardado = true;
	private static boolean guardadoprimeravez = false;
	private static JFileChooser jf = new JFileChooser();
	private static FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Objetos (.obj)", "obj");
	private static int opcion;
	private static int respuesta;
	private final static String message = "Error, no se ha podido hacer la operación con el archivo";
	
	/**
	 * Comprueba que se guarde el almacen
	 * @throws IOException Excepción de entrada/salida de ficheros
	 * @throws FileNotFoundException Excepción de Archivo no encontrado
	 */
	static void guardar() throws FileNotFoundException, IOException{
		if(guardadoprimeravez == false){
			guardarComo();
		}
		else{
			try {
				Fichero.guardar(file,almacen);
				JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente");
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, message);
			}
		}
		setModificado(false);

	}
	
	/**
	 * Comprueba el método guardarComo()
	 * @throws IOException Excepción de entrada/salida de ficheros
	 * @throws FileNotFoundException Excepción de Archivo no encontrado
	 * 
	 */
	static void guardarComo() throws FileNotFoundException, IOException {
		jf.setFileFilter(filter);
		opcion = jf.showSaveDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION){
			file = jf.getSelectedFile();
			if (file.exists()){
				respuesta = JOptionPane.showConfirmDialog(null, "¿Desea sobreescribir el archivo?",
						"Sobreescribir", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
				if(respuesta == JOptionPane.YES_OPTION){
					Fichero.guardar(file, almacen);
					setGuardadoprimeravez(true);
					setModificado(false);
					setGuardado(true);
				}
				else{
					setGuardado(false);
					return;
				}
			}else{
				Fichero.guardar(file, almacen);
				setGuardado(true);
				setModificado(false);
				setGuardadoprimeravez(true);
			}
			frame.setTitle(file.getName());
		}else{
			setModificado(true);
			setGuardado(false);
			return;
		}
	}
	
	public static void comprobarGuardadoNuevo() throws FileNotFoundException, IOException {
		if (modificado == true || guardado == false){
			file = null;
			respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios realizados?", 
					"Concesionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
			if(respuesta == JOptionPane.YES_OPTION){
				guardarComo();
				almacen = new TiendaOrdenador();
				setGuardado(true);
				setModificado(false);
			}
			if (respuesta == JOptionPane.NO_OPTION){
				almacen = new TiendaOrdenador();
				file = new File("SinTitulo.obj");
				frame.setTitle(file.getName());
				setModificado(false);
				setGuardado(true);
			}else{
				return;
			}
			frame.setTitle(file.getName());
		}else{
			almacen = new TiendaOrdenador();
			file = new File("SinTitulo.obj");
			frame.setTitle(file.getName());
		}
		setGuardadoprimeravez(false);
	}
	
	static void comprobarGuardadoAbrir() throws ClassNotFoundException, FileNotFoundException, IOException {
		file = null;
		if (modificado == true || guardado == false){
			respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios realizados?", 
					"Concesionario", JOptionPane.YES_NO_CANCEL_OPTION);
			if(respuesta == JOptionPane.YES_OPTION){
				guardarComo();
				setModificado(false);
				setGuardado(true);
				abrir();
			}
			if (respuesta == JOptionPane.NO_OPTION){
				file = null;
				setModificado(false);
				setGuardado(true);
				abrir();
			}
			else
				return;
			frame.setTitle(file.getName());
		}else {
			abrir();
		}
		setGuardado(true);
		
	}
	
	static void abrir() throws ClassNotFoundException {
		jf.setFileFilter(filter);
		opcion = jf.showOpenDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION){
			file = jf.getSelectedFile();
			try{
				almacen = (TiendaOrdenador) Fichero.abrir(file);
				frame.setTitle(file.getName());
				setGuardado(true);
				setModificado(false);
				setGuardadoprimeravez(true);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, message);
			}
		}else
			return;
		setModificado(false);
		setGuardado(true);
		setGuardadoprimeravez(true);
	}
	
	static void salir() throws FileNotFoundException, IOException {
		if(modificado == true){
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?",
					"¿Deseas salir?", JOptionPane.YES_NO_CANCEL_OPTION);
			if(respuesta == JOptionPane.CANCEL_OPTION){
				return;
			}
			if(respuesta == JOptionPane.YES_OPTION){
				if (guardado == true){
					Fichero.guardar(file, almacen);
					setGuardado(true);
					System.exit(0);
				}
				else{
					guardarComo();
					if (guardado == true)
						System.exit(0);
					else return;
				}
			}else{
				System.exit(0);
			}
		}else
			System.exit(0);
	}
	
	static void annadirSobremesa(TiendaOrdenador almacen) {
		alta = new AnnadirSobremesa(almacen);
		alta.setVisible(true);
	}
	
	static void annadirPortatil(TiendaOrdenador almacen) {
		AnnadirPortatil alta = new AnnadirPortatil(almacen);
		alta.setVisible(true);
	}
	
	static void baja(TiendaOrdenador almacen) {
		if (almacen.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay ordenadores en el almacén.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}

	static void setGuardadoprimeravez(boolean b) {
		Generar.guardadoprimeravez = b;
	}
	
	static void setGuardado(boolean b) {
		guardado = b;
	}

	static void setModificado(boolean b){
		modificado = b;
	}
	
}
