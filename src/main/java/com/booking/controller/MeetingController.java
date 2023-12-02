package com.booking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.booking.service.SessionService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/cancel/{meetingId}")
    public void cancelMeeting(@PathVariable Long meetingId) {
    	sessionService.cancelsession(meetingId);
    }

    @PostMapping("/reschedule/{meetingId}")
    public void rescheduleMeeting(@PathVariable Long meetingId,
                                  @RequestParam LocalDateTime newTime) {
    	sessionService.reschedulesession(meetingId, newTime);
    }

    @PostMapping("/book/recurring")
    public void bookRecurringMeeting(@RequestParam Long mentorId,
                                     @RequestParam Long userId,
                                     @RequestParam LocalDateTime startDate,
                                     @RequestParam int frequency,
                                     @RequestParam int durationInMonths) {
    	sessionService.bookRecurringsession(mentorId, userId, startDate, frequency, durationInMonths);
    }
}
