package com.illud.crimestopperDemo1.client.crimestopperdemo2.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.illud.crimestopperDemo1.client.crimestopperdemo2.model.Person;

@FeignClient(name = "crimestopperDemo2", url = "http://localhost:8082/api2")
public interface CrimeStopperDemo2ResourceApi {

	@GetMapping("/hello")
	public String show();

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getOne(@PathVariable (value="id") Long id);

}
