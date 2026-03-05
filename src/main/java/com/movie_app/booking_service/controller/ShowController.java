package com.movie_app.booking_service.controller;


import org.springframework.web.bind.annotation.*;

import com.movie_app.booking_service.entity.Seat;
import com.movie_app.booking_service.entity.Show;
import com.movie_app.booking_service.service.ShowService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

	
    private final ShowService showService;

    @GetMapping
    public List<Show> browse(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam String date) {

        return showService.browseShows(
                movieId,
                city,
                LocalDate.parse(date));
    }
    
    @GetMapping("/city/{city}")
    public List<Show> getShowsByCity(@PathVariable String city) {
        return showService.getShowsByCity(city);
    }
    
    @GetMapping("/{showId}")
    public List<Seat> getAvailableSeats(@PathVariable Long showId) {

        return showService.getAllSeats(showId);
    }
}
