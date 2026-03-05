package com.movie_app.booking_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {

	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long userId;

	    @ManyToOne
	    private Show show;

	    private Double totalAmount;
	    private String status;
}