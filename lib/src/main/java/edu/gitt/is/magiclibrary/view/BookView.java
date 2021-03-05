package edu.gitt.is.magiclibrary.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.gitt.is.magiclibrary.controller.BookListener;
import edu.gitt.is.magiclibrary.model.entities.Book;

import java.awt.BorderLayout;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BookView extends TitleView {
	private static Logger log=Logger.getLogger(BookView.class.getName());
	
	private JTextField isbnField;
	private JTextField pagesField;
	private JLabel isbnLabel;
	private JLabel pagesLabel;

	


	/**
	 * Creaci�n de la vista vac�a. Se usar� para introducir b�squedas o los datos de un libro nuevo
	 */
	public BookView() {
		super();
		createPanel();
	}
	/**
	 * Creaci�n de la vista con los datos de un libro. Se usar� para presentar los datos de un libro ya existente para su edici�n o eliminaci�n
	 * @param book El libro a presentar en la vista
	 */
	public BookView(Book book) {
		
		createPanel();
		this.setBook(book);
	}
	/**
	 * Crea el panel
	 */
	private void createPanel() {
		log.info("Creando el panel de libro");
	
		
		isbnField = new JTextField();
		isbnField.setName("isbn");
		isbnField.setBounds(140, 166, 300, 20);
		add(isbnField);
		isbnField.setColumns(10);
		
		isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(33, 169, 46, 14);
		add(isbnLabel);
		
		pagesField = new JTextField();
		pagesField.setName("pages");
		pagesField.setBounds(140, 203, 300, 20);
		add(pagesField);
		pagesField.setColumns(10);
		
		pagesLabel = new JLabel("Pages");
		pagesLabel.setBounds(33, 206, 46, 14);
		add(pagesLabel);
		

	}


	/**
	 * M�todo par establecer el libro en la vista, se mostrar�n sus datos por pantalla
	 * @param book Libro que queremos mostrar por pantalla
	 */
	public void setBook(Book book) {
		this.setTitle(book);
		isbnField.setText(book.getIsbn());		
		pagesField.setText(Integer.toString(book.getPages()));
	}
	/**
	 * 
	 * @return Devuelve un Book con los datos correspondientes a las casillas de texto de la vista
	 */
	
	public Book getBook() {
		Book book=null;
		if (this.entity==null){
			try {
				book = new Book(nameField.getText(),authorField.getText(),format.parse(publishedAtField.getText()),isbnField.getText(),Integer.parseUnsignedInt(pagesField.getText()));
			} catch (Exception e) {
			
				e.printStackTrace();
			} 
	
			//super.setTitle(book);
			setEntity(book);
		}else {
			entity.setAuthor(authorField.getText());
			entity.setName(nameField.getText());
			
			try {
				entity.setPublishedAt(format.parse(publishedAtField.getText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			book=(Book) entity;
		}
		book.setIsbn(isbnField.getText());
		book.setPages(Integer.parseUnsignedInt(pagesField.getText()));
		
		return book;
	}

}
