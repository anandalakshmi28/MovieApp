package com.movie_app.booking_service.service;

import org.springframework.stereotype.Service;

import com.movie_app.booking_service.dto.CreateShowRequest;
import com.movie_app.booking_service.entity.Movie;
import com.movie_app.booking_service.entity.Show;
import com.movie_app.booking_service.entity.Theatre;
import com.movie_app.booking_service.repository.MovieRepository;
import com.movie_app.booking_service.repository.ShowRepository;
import com.movie_app.booking_service.repository.TheatreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;

    public Show createShow(CreateShowRequest  request) {
    	 Movie movie = movieRepository.findById(request.getMovieId())
                 .orElseThrow(() -> new RuntimeException("Movie not found"));

         Theatre theatre = theatreRepository.findById(request.getTheatreId())
                 .orElseThrow(() -> new RuntimeException("Theatre not found"));

         Show show = new Show();
         show.setMovie(movie);
         show.setTheatre(theatre);
         show.setShowDate(request.getShowDate());
         show.setShowTime(request.getShowTime());
         show.setPrice(request.getPrice());

         return showRepository.save(show);
    }

    public Show updateShow(Long id, Show updatedShow) {

        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        show.setShowTime(updatedShow.getShowTime());
        show.setPrice(updatedShow.getPrice());

        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}
