package com.movie_app.booking_service.controller;

import org.springframework.web.bind.annotation.*;

import com.movie_app.booking_service.dto.CreateShowRequest;
import com.movie_app.booking_service.entity.Show;
import com.movie_app.booking_service.service.TheatreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/theatre")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    // Create show
    @PostMapping("/shows")
    public Show createShow(@RequestBody CreateShowRequest request) {

        return theatreService.createShow(request);
    }

    // Update show
    @PutMapping("/shows/{id}")
    public Show updateShow(
            @PathVariable Long id,
            @RequestBody Show show) {

        return theatreService.updateShow(id, show);
    }

    // Delete show
    @DeleteMapping("/shows/{id}")
    public String deleteShow(@PathVariable Long id) {

        theatreService.deleteShow(id);

        return "Show deleted successfully";
    }
}