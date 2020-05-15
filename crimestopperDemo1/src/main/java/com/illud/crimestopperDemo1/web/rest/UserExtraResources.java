package com.illud.crimestopperDemo1.web.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.client.RestTemplate;

import com.illud.crimestopperDemo1.client.crimestopperdemo2.api.CrimeStopperDemo2ResourceApi;
import com.illud.crimestopperDemo1.client.crimestopperdemo2.model.Person;
import com.illud.crimestopperDemo1.domain.UserExtra;
import com.illud.crimestopperDemo1.service.UserExtraService;

@RestController
@RequestMapping("api1")
public class UserExtraResources {

	Logger log = LoggerFactory.getLogger(UserExtraResources.class);

	@Autowired
	UserExtraService userExtraService;

	@Autowired
	RestTemplate rest;

	@Autowired
	CrimeStopperDemo2ResourceApi crimeApi;

	@GetMapping("hlo")
	public String hello() {
		return crimeApi.show();

	}

	@GetMapping("/per/{id}")
	public ResponseEntity<Person> getOne(@PathVariable Long id) {
		log.debug("<<<<<<<< apiiiiiiisssssssssssssssss   >>>>>{}", id);
		return crimeApi.getOne(id);

	}

	@PostMapping("/user")
	public ResponseEntity<UserExtra> createUserExtra(@RequestBody UserExtra userExtra) {
		log.debug("<<<<<<<<< createUserExtra in ctrl>>>>>>>>>{}", userExtra);
		return userExtraService.createUserExtra(userExtra);
	}

	@PutMapping("/user")
	public ResponseEntity<UserExtra> updateUserExtra(@RequestBody UserExtra userExtra) {
		log.debug("<<<<<<<<< updateUserExtra in ctrl>>>>>>>>>{}", userExtra);
		return userExtraService.updateUserExtra(userExtra);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<UserExtra>> getUserExtra(@PathVariable Long id) {
		log.debug("<<<<<<<<< getUserExtra in ctrl>>>>>>>>>{}", id);
		return userExtraService.getUserExtra(id);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUserExtra(@PathVariable Long id) {
		log.debug("<<<<<<<<< deleteUserExtra in ctrl>>>>>>>>>{}", id);
		userExtraService.deleteUserExtra(id);
		HttpHeaders header = new HttpHeaders();
		header.add("delete phoneNumber ", id.toString());
		return ResponseEntity.noContent().headers(header).build();
	}

}
