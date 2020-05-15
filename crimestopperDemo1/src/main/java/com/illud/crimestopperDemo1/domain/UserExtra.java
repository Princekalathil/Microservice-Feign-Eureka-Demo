package com.illud.crimestopperDemo1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserExtra {
	
	
	
	public UserExtra(Long id, String houseName, Long houseNumber, Long pin) {
		super();
		this.id = id;
		this.houseName = houseName;
		this.houseNumber = houseNumber;
		this.pin = pin;
	}
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	private String houseName;
	private Long houseNumber;
	private Long pin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public Long getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Long houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}

}
