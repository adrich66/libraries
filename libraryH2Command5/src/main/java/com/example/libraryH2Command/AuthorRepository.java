package com.example.libraryH2Command;

import org.springframework.data.repository.CrudRepository;

public interface  AuthorRepository extends CrudRepository <Author, String> {
	
	void save(User author);
	
	void deleteByName(String lastname);
	
	void countByName(String lastname);

}
