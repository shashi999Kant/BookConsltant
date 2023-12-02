package com.booking.service;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entities.Session;
import com.booking.repository.SessionRepository;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public void cancelsession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("session not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime sessionTime = session.getTime();
        if (currentTime.isBefore(sessionTime.minusHours(12))) {
            sessionRepository.delete(session);
        } else {
            throw new IllegalArgumentException("session can only be canceled 12 hours before the scheduled time.");
        }
    }

    public void reschedulesession(Long sessionId, LocalDateTime newTime) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("session not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(newTime.minusHours(4))) {
            session.setTime(newTime);
            sessionRepository.save(session);
        } else {
            throw new IllegalArgumentException("session can only be rescheduled 4 hours before the scheduled time.");
        }
    }

    public void bookRecurringsession(Long mentorId, Long userId, LocalDateTime startDate, int frequency, int durationInMonths) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime nextsessionTime = startDate;

        for (int i = 0; i < durationInMonths; i++) {
            sessionRepository.save(new Session(userId, mentorId, nextsessionTime, nextsessionTime, currentTime));
            nextsessionTime = nextsessionTime.plusWeeks(frequency);
        }
    }
}
