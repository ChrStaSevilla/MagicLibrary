/**
 * Controlador principal para arrancar la aplicaci�n Magic Library, construye la vista principal y los controladores para cada tipo de entidad
 */
package edu.gitt.is.magiclibrary.controller;

import java.util.logging.Logger;

import edu.gitt.is.magiclibrary.view.MagicLibraryView;

/**
 * @author Isabel Rom�n
 *
 */
public class MagicLibrary {
	private static Logger log=Logger.getLogger(MagicLibrary.class.getName());
	private static BookListener bookListener;
	private static ItemListener itemListener;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("Arranco la aplicaci�n y creo el controlador para manejar entidades desde la interfaz");

		bookListener=new BookListener();

		MagicLibraryView.getFrameManager().setEntityMenu("Book", bookListener);
		itemListener=new ItemListener();
		MagicLibraryView.getFrameManager().setEntityMenu("Item", itemListener);
	
	}

}
