package com.illud.crimestopperDemo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.illud.crimestopperDemo1.domain.UserExtra;

@Repository
public interface UserExtraRepository extends JpaRepository<UserExtra, Long>{

}
