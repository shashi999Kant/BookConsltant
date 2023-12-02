package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.role = 'consultant'")
	List<User> findAllConsultant();


}
