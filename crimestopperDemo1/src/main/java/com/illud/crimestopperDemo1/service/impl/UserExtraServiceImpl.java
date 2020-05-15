package com.illud.crimestopperDemo1.service.impl;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.illud.crimestopperDemo1.domain.UserExtra;
import com.illud.crimestopperDemo1.repo.UserExtraRepository;
import com.illud.crimestopperDemo1.service.UserExtraService;

@Service
public class UserExtraServiceImpl implements UserExtraService{
	
	Logger log = LoggerFactory.getLogger(UserExtraServiceImpl.class);
	
	@Autowired
	UserExtraRepository userRepo; 

	@Override
	public ResponseEntity<UserExtra> createUserExtra(UserExtra userExtra) {
		log.debug("<<<<<<<<< createUserExtra in impl >>>>>>>>",userExtra);
		return ResponseEntity.ok().body(userRepo.save(userExtra));
	}

	@Override
	public ResponseEntity<UserExtra> updateUserExtra(UserExtra userExtra) {
		log.debug("<<<<<<<<< updateUserExtra in impl >>>>>>>>",userExtra);
		return ResponseEntity.ok().body(userRepo.save(userExtra));
	}

	@Override
	public ResponseEntity<Optional<UserExtra>> getUserExtra(Long id) {
		log.debug("<<<<<<<<< createUserExtra in impl >>>>>>>>",id);
		return ResponseEntity.ok().body(userRepo.findById(id));
	}

	@Override
	public void deleteUserExtra(Long id) {
		log.debug("<<<<<<<<< deleteUserExtra in impl >>>>>>>>",id);
		Optional<UserExtra> user = userRepo.findById(id);
		if(user.isPresent()) {
			userRepo.deleteById(id);
		}
		else {
			System.out.println("they have no data ");
		}
	}

}
