package com.illud.crimestopperDemo2.web.rest;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.illud.crimestopperDemo2.domain.Person;
import com.illud.crimestopperDemo2.service.PersonService;

@RestController
@RequestMapping("api2")
public class PersonResources {
	
	@Autowired
	PersonService personService;
	
	Logger log= LoggerFactory.getLogger(PersonResources.class);
	
	@GetMapping("/hello")
	public String show(){
		return "hai hello prince";
		
	}
	@GetMapping("hellos")
	public List<String> shows(){
		List<String> strs =Arrays.asList(
				new String("hai 1"),new String("hai 2")
				);
				
		
		return strs;
		
	}
	
	@PostMapping("/person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		log.debug("<<<<<<<<< createPerson in controller >>>>>>>>>",person);
		
		return personService.createPerson(person);
		
	}
	@PutMapping("/person")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person){
		log.debug("<<<<<<<<< updatePerson in controller >>>>>>>>>",person);
		
		return personService.updatePerson(person);
	}
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getOne(@PathVariable Long id){
		log.debug("<<<<<<<< getOne in impl >>>>>>>> ",id);
		
		return personService.getOne(id);
		
	}
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Void> DeleteId(@PathVariable Long id){
		log.debug("<<<<<<<< deleteId in impl >>>>>>>> ",id);
		personService.deleteById(id);
		HttpHeaders header = new HttpHeaders();
		header.add("delete by id", id.toString());
		
		return ResponseEntity.noContent().headers(header).build();
		
	}

}
