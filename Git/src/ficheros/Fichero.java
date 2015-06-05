package ficheros;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import ordenadores.TiendaOrdenador;

/**
 * Clase que permite la lectura y escritura de objetos
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Fichero implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Object abrir(File file) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		file = annadirExtension(file);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				file))) {
			return (Object) ois.readObject();
		}
	}

	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".obj"))
			return new File(archivo + ".obj");
		return archivo;
	}

	public static void guardar(File file, TiendaOrdenador almacen) throws FileNotFoundException, IOException {
		file = annadirExtension(file);
			if(!file.exists()){
				try (ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(file, false)))){
					oos.writeObject(almacen);
		        } catch (IOException ex) {
		        }
			}else{
				try (ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(file, false)))){
					oos.writeObject(almacen);
				}
			}
	}
	
}

