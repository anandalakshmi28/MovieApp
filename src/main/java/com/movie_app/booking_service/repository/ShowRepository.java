package com.movie_app.booking_service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_app.booking_service.entity.Show;



public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("SELECT s FROM Show s WHERE s.movie.id = :movieId " +
           "AND s.theatre.city = :city AND s.showDate = :date")
    List<Show> findShows(Long movieId, String city, LocalDate date);
    
    List<Show> findByTheatreCity(String city);
}
