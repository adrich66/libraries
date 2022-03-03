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
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	AuthorService authorService;


	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner to test JPA mapping 1:n");

		User user1 = new User("U001","Tom", "Holland",1996);
		User user2 = new User("U002", "Scarllet", "Johansson", 1983);
		User user3 = new User("U003", "Brad", "Pitt", 1963);
		User user4 = new User("U004", "Dwayne", "Johnson", 1972);
		
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);
		
		Book book1 = new Book("B001", "Guerra y paz", "Tolstoi", 1900, 1869, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("B002", "Así habló Zaratustra", "Friedrich Nietzsche", 520, 1883, "978-84-206-5091-3");
		Book book3 = new Book("B003","Kafka en la orilla", "Haruki Murakami", 720, 2008, "9788483835241");
		Book book4 = new Book("B004", "1Q84 Libros 1 y 2", "Haruki Murakami", 744, 2011, "9788483832967");
		Book book5 = new Book("B005", "Craft beer for the people", "Brew Dog", 150, 2019, "4455645-GWR-456");

		bookService.save(book1);
		bookService.save(book2);
		bookService.save(book3);
		bookService.save(book4);
		bookService.save(book5);
		
		userService.save(new User("U005", "Leonardo", "DiCaprio", 1975));
		
		//we add to arraylist books of user 
		user1.addBook(book1);
		user1.addBook(book2);
		user1.addBook(book3);
		user2.addBook(book3);
		
		//save to bd by JPA query crudrepository-service
		userService.save(user1);
		userService.save(user2);
		
		logger.info("toString user1 " + user1);
		logger.info("toString user2 " + user2);
		
		logger.info("user1 get books " + user1.getBooks());
		logger.info("user2 get books " + user2.getBooks());
		
		Author author1 = new Author("A001", "Leo Tolstoi", "Russian");
		Author author2 = new Author("A002", "Haruki _Murakami", "Japanese");
		Author author3 = new Author("A003", "Brew Dog", "Scottish");
		
		authorService.save(author1);
		authorService.save(author2);
		authorService.save(author3);
		
		author2.addBook(book3);
		author2.addBook(book4);
		author1.addBook(book1);
		
		authorService.save(author2);
		logger.info("author2 get books " + author2.getBooks());
	}

}