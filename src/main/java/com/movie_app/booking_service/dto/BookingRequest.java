package com.movie_app.booking_service.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
public class BookingRequest {
    private Long userId;
    private Long showId;
    private List<String> seats;
}
