package com.movie_app.booking_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;
    private String genre;
}