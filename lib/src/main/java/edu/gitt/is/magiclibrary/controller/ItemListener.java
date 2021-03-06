/**
 * 
 */
package edu.gitt.is.magiclibrary.controller;


import edu.gitt.is.magiclibrary.model.JpaItemDao;

import edu.gitt.is.magiclibrary.model.entities.Item;
import edu.gitt.is.magiclibrary.view.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.*;

import javax.swing.event.ListSelectionEvent;


/**
 * <p>Controlador de la vista de Ejemplares. Est� sin terminar y tiene problemas graves, como por ejemplo al crear uno no se especifica tipo de t�tulo y no permite
 * asociarlo con uno ya existente</p>
 * @author Isabel Rom�n
 *
 */
public class ItemListener extends CrudListener<Item>{

	private static Logger log=Logger.getLogger(ItemListener.class.getName());


	@Override
	void search() {
		String inventoryNr=view.getAttributeAsString("inventoryNr");
		
		if((!inventoryNr.isEmpty()) && (inventoryNr!="*")) {
			log.info("Buscando un ejemplar con Id ="+inventoryNr);
			Optional<Item> recuperado = ((JpaItemDao) entityDao).findById(inventoryNr);
						
			if(recuperado.isPresent()) {
				MLView.getFrameManager().discard(view);
				setView(recuperado.get());
			
			}else {
				log.info("Ejemplar no encontrado");
				MLView.getFrameManager().discard(view);
			}
		}else {
			log.info("Buscando todos los ejemplares");
			List<Item> recuperados=((JpaItemDao) entityDao).findAll();
			MLView.getFrameManager().discard(view);
			setView(recuperados);
		}		
	}
	/**
	 * Responde a los cambios en la lista de m�ltiples ejemplares
	 */
	public void valueChanged(ListSelectionEvent e) {
		log.info("Cambia la selecci�n en la lista");		
		((ItemView) view).setEntity((Item)view.getSelectedValue());
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