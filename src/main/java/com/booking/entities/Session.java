package com.booking.entities;
// Session.java
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Session {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private Long mentorId;
    private LocalDateTime date;
    private LocalDateTime time;
    private LocalDateTime bookedAt;
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getMentorId() {
		return mentorId;
	}
	public void setMentorId(Long mentorId) {
		this.mentorId = mentorId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public LocalDateTime getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(LocalDateTime bookedAt) {
		this.bookedAt = bookedAt;
	}
	

    
	public Session() {
		super();
	}
	public Session(Long userId, Long mentorId, LocalDateTime date, LocalDateTime time, LocalDateTime bookedAt) {
		super();
		this.userId = userId;
		this.mentorId = mentorId;
		this.date = date;
		this.time = time;
		this.bookedAt = bookedAt;
	}
    
    
}
