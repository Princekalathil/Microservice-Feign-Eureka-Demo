package com.illud.crimestopperDemo2.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.illud.crimestopperDemo2.domain.Person;
import com.illud.crimestopperDemo2.repository.PersonRepository;
import com.illud.crimestopperDemo2.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	Logger log= LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	PersonRepository personRepo;

	@Override
	public ResponseEntity<Person> createPerson(Person person) {
		log.debug("<<<<<<<<createPerson in impl >>>>",person);
		return ResponseEntity.ok().body(personRepo.save(person));
	}

	@Override
	public ResponseEntity<Person> updatePerson(Person person) {
		log.debug("<<<<<<<<updatePerson in impl >>>>",person);
		return ResponseEntity.ok().body(personRepo.save(person));
	}

	@Override
	public ResponseEntity<Person> getOne(Long id) {
		log.debug("<<<<<<<<getOnePerson in impl >>>>",id);
		//Person roomEntity =  personRepo.findById(id);
		Optional<Person> opt =  personRepo.findById(id);
		//Person roomEntity = optionalEntity.get();
	
		return ResponseEntity.ok().body(opt.get());
	}
	@Override
	public void deleteById(Long id) {
		log.debug("<<<<<<<<<<deleteById >>>>>",id);
		Optional<Person> person = personRepo.findById(id);
		if(person.isPresent()) {
			personRepo.deleteById(id);
		}
		else {
			System.out.println("record not found in database ");
		}
	}
	

}
