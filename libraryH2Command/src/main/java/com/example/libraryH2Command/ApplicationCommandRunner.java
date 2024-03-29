package com.example.libraryH2Command;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());	
	
	@Autowired
	BookService bookservice;
	

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Welcome to the runner from commandLineRunner");
		

		// String title, String author, int pages, int year, String iSBN
		Book book1 = new Book("Guerra y paz", "Tolstoi", 1900, 1869, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("Así habló Zaratustra", "Friedrich Nietzsche", 520, 1883, "978-84-206-5091-3");
		Book book3 = new Book("Kafka en la orilla", "Haruki Murakami", 720, 2008, "9788483835241.");
		Book book4 = new Book("1Q84 Libros 1 y 2", "Haruki Murakami", 744, 2011, "9788483832967");
		// Book book4 = new Book ();
		// Book book5 = new Book ();
		// Book book6 = new Book ();
		
		bookservice.addBookToH2(book1);
		bookservice.addBookToH2(book2);
		bookservice.addBookToH2(book3);
		bookservice.addBookToH2(book4);
		
		logger.info(bookservice.queryBooksFromH2());
		
		
	}
	
}