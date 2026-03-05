package com.movie_app.booking_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
}
