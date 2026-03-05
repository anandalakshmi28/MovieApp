package com.movie_app.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_app.booking_service.entity.Booking;



public interface BookingRepository extends JpaRepository<Booking, Long> {
}