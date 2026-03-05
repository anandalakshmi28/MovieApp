package com.movie_app.booking_service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CreateShowRequest {

    private Long movieId;
    private Long theatreId;

    private LocalDate showDate;
    private LocalTime showTime;

    private Double price;
}