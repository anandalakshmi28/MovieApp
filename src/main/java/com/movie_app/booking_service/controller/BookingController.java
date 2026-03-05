package com.movie_app.booking_service.controller;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import com.movie_app.booking_service.dto.BookingRequest;
import com.movie_app.booking_service.entity.Booking;
import com.movie_app.booking_service.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {

      try
      {
    	return bookingService.bookTickets(
                request.getUserId(),
                request.getShowId(),
                request.getSeats());
    } catch (ObjectOptimisticLockingFailureException ex) {
        throw new RuntimeException("Seat already booked by another user");
    }
    }
}