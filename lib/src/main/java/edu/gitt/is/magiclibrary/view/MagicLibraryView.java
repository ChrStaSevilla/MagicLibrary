package edu.gitt.is.magiclibrary.view;


import javax.swing.JFrame;

import javax.swing.JMenuBar;

import java.util.logging.Logger;





/**
 * @author Isabel Rom�n
 * <p>Esta clase permite crear un objeto (�nico) contenedor de la GUI de la aplicaci�n MagicLibrary, de tipo {@link java.swing.JFrame}</p>
 * <p>Cada vista se configura incluyendo y eliminando los componentes de este contenedor principal</p>
 *
 */
public class MagicLibraryView {
	private static Logger log=Logger.getLogger(MagicLibraryView.class.getName());
	
	private static JFrame frame;
	private static FrameManagerI myFrameManager=null;
	private static MagicLibraryView mainWindow=null;


	

	/**
	 * Crea la Vista principal
	 */
	private MagicLibraryView() {
		
	}

	public static FrameManagerI getFrameManager() {
		
		if (myFrameManager==null){
			log.info("Creo el MagicLibraryView");
			mainWindow=new MagicLibraryView();
			mainWindow.initialize();
			frame.setVisible(true);
			
		}
		return myFrameManager;
	}

	/**
	 * Inicia los contenidos de la vista principal de Magic Library, simplemente una barra de men�
	 */
	private void initialize() {
		log.info("Creo el JFrame principal, el frameManager y la barra de Men�");
		frame = new JFrame();
		myFrameManager = new FrameManager(frame);
		
		JMenuBar menuBar = new JMenuBar();
	
		frame.setJMenuBar(menuBar);	
		menuBar.setVisible(true);
	}
	
	


}
