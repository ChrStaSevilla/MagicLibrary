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
public class MLView {
	private static Logger log=Logger.getLogger(MLView.class.getName());
	
	private static JFrame frame;
	private static FrameManagerI myFrameManager=null;
	private static MLView mainWindow=null;



	

	/**
	 * Crea la Vista principal
	 */
	private MLView() {
		
	}

	public static FrameManagerI getFrameManager() {
		
		if (myFrameManager==null){
			log.info("Creo la vista principal de Magic Library");
			mainWindow=new MLView();
			mainWindow.initialize();
			frame.setVisible(true);
			
		}
		return myFrameManager;
	}

	/**
	 * <p> Inicia los contenidos de la vista principal de Magic Library, simplemente una barra de men�</p>
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
