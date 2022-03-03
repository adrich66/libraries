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

	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner");

		
		User user1 = new User("1","Tom", "Holland");
		User user2 = new User("2", "Scarllet", "Johansson");
		User user3 = new User("3", "Brad", "Pitt");
		User user4 = new User("4", "Dwayne", "Johnson");
		
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);
		
		Book book1 = new Book("B001", "Guerra y paz", "Tolstoi", 1900, 1869, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("B002", "Así habló Zaratustra", "Friedrich Nietzsche", 520, 1883, "978-84-206-5091-3");
		Book book3 = new Book("B003","Kafka en la orilla", "Haruki Murakami", 720, 2008, "9788483835241.");
		
		
		bookService.save(book1);
		bookService.save(book2);
		bookService.save(book3);
		
		//logger.info("count: " + bookService.count());
		logger.info(bookService.findAll());
		
		
		logger.info("count: " + userService.count());
		logger.info(userService.findAll());
		logger.info("exists ['1']: " + userService.existsById("1"));
		
		
		userService.findAndDeleteById("1");
		
		logger.info("count: " + userService.count());
		logger.info(userService.findAll());
		logger.info("exists ['1']: " + userService.existsById("1"));
		
		userService.save(new User("5", "Paul", "Mendez"));
		

		logger.info("count: " + userService.count());
		logger.info(userService.findAll());
		logger.info("exists ['1']: " + userService.existsById("1"));
		logger.info("exists ['5']: " + userService.existsById("5"));
		
		user2.setFirstName("Olga");
		logger.info("count: " + userService.count());
		userService.update("2", user2);
		logger.info(userService.findAll());
		
		logger.info("count by lastname: " + userService.countByLastname("Gates"));

		book1.setUser(user2);
		book2.setUser(user2);
		book3.setUser(user2);
		
		bookService.save(book1);
		bookService.save(book2);
		bookService.save(book3);
		
		logger.info("toString book1: " + book1);
		logger.info("toString book1: " + book1.getTitle());
		logger.info("toString user2: " + user2);
		
		Book book4 = new Book ("B004", "I LOVE Js", "Anna", 2, 2023, "GWR-456" );
		book4.setUser(user3);
		bookService.save(book4);
		
	}

}