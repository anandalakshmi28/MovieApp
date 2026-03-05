package com.movie_app.booking_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_app.booking_service.discounts.DiscountStrategy;
import com.movie_app.booking_service.entity.*;
import com.movie_app.booking_service.repository.*;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

	@Autowired
    private final SeatRepository seatRepository;
	@Autowired
    private final BookingRepository bookingRepository;
	@Autowired
    private final List<DiscountStrategy> discountStrategies;

    @Transactional
    public Booking bookTickets(Long userId,
                               Long showId,
                               List<String> seatsRequested) {

        List<Seat> seats =
                seatRepository.findAvailableSeats(showId, seatsRequested);

        if (seats.size() != seatsRequested.size()) {
            throw new RuntimeException("Seats not available");
        }

        seats.forEach(s -> s.setStatus("BOOKED"));

        Show show = seats.get(0).getShow();

        Double total = show.getPrice() * seatsRequested.size();

        for (DiscountStrategy strategy : discountStrategies) {
            total = strategy.apply(total, seatsRequested.size(), show);
        }

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShow(show);
        booking.setTotalAmount(total);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}
