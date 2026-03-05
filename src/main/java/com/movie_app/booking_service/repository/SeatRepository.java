package com.movie_app.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_app.booking_service.entity.Seat;



public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.show.id = :showId " +
           "AND s.seatNumber IN :seats AND s.status = 'AVAILABLE'")
    List<Seat> findAvailableSeats(Long showId, List<String> seats);

    @Query("SELECT s FROM Seat s WHERE s.show.id = :showId")
	List<Seat> findAllByShow(Long showId);

    

}
