package com.example.libraryH2Command;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

	long countByLastName(String lastname);

	void deleteByLastName(String lastname);

	

}