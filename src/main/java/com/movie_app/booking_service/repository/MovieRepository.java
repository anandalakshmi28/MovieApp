package com.movie_app.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_app.booking_service.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
