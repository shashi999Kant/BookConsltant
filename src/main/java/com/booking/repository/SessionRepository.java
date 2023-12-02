package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
