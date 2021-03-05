/**
 * 
 */
package edu.gitt.is.magiclibrary.controller;

import edu.gitt.is.magiclibrary.model.JpaBookDao;
import edu.gitt.is.magiclibrary.model.JpaItemDao;
import edu.gitt.is.magiclibrary.model.entities.Book;
import edu.gitt.is.magiclibrary.model.entities.Item;
import edu.gitt.is.magiclibrary.view.*;

import java.util.Optional;
import java.util.logging.*;


/**
 * @author Isabel Rom�n
 *
 */
public class ItemListener extends CrudListener<Item>{

	private static Logger log=Logger.getLogger(ItemListener.class.getName());


	@Override
	void search() {
		Optional<Item> recuperado = ((JpaItemDao) entityDao).findById(view.getAttributeAsString("inventoryNr"));	
		if(recuperado.isPresent()) {
			MagicLibraryView.getFrameManager().discard(view);
			setView(recuperado.get());
			
		}else {
			log.info("Ejemplar no encontrado");
			MagicLibraryView.getFrameManager().discard(view);
		}
		
	}

	@Override
	ItemView newView() {
		return new ItemView();
	}

	@Override
	ItemView newView(Item entity) {
		return new ItemView(entity);
	}

	@Override
	JpaItemDao newDao() {
		
		return new JpaItemDao();
	}

	@Override
	void save() {
		entity=((ItemView) view).getItem();
		log.info("Voy a guardar la entidad "+entity);
		((JpaItemDao) entityDao).save((Item) entity);
		
	}
	/**
	 * Establece la vista de libro vac�a para buscar un libro, s�lo habilita la introducci�n del n�mero de inventario
	 */
	protected void setSearchView() {	
		log.info("Estableciendo vista de libro vac�a para buscar por n�mero de inventario");
		setSearchView("inventoryNr");
	
	}

	
}