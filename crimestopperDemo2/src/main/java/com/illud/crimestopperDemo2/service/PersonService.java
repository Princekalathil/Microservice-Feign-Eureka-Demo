package com.illud.crimestopperDemo2.service;

import org.springframework.http.ResponseEntity;

import com.illud.crimestopperDemo2.domain.Person;

public interface PersonService {

	ResponseEntity<Person> createPerson(Person person);

	ResponseEntity<Person> updatePerson(Person person);

	ResponseEntity<Person> getOne(Long id);

	

	void deleteById(Long id);

	

}
