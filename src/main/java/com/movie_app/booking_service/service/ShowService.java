package com.movie_app.booking_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie_app.booking_service.entity.Seat;
import com.movie_app.booking_service.entity.Show;
import com.movie_app.booking_service.repository.SeatRepository;
import com.movie_app.booking_service.repository.ShowRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    public List<Show> browseShows(Long movieId, String city, LocalDate date) {
        return showRepository.findShows(movieId, city, date);
    }
    
    public List<Show> getShowsByCity(String city) {
        return showRepository.findByTheatreCity(city);
    }

	public List<Seat> getAllSeats(Long showId) {
		// TODO Auto-generated method stub
		return seatRepository.findAllByShow(showId);
	}
    
    
}
