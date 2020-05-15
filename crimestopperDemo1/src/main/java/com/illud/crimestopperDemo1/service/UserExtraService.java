package com.illud.crimestopperDemo1.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.illud.crimestopperDemo1.domain.UserExtra;

public interface UserExtraService {

	ResponseEntity<UserExtra> createUserExtra(UserExtra userExtra);

	ResponseEntity<UserExtra> updateUserExtra(UserExtra userExtra);

	ResponseEntity<Optional<UserExtra>> getUserExtra(Long id);

	void deleteUserExtra(Long id);

}
