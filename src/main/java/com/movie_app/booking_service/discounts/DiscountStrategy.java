package com.movie_app.booking_service.discounts;

import com.movie_app.booking_service.entity.Show;

public interface DiscountStrategy {
    double apply(double total, int ticketCount, Show show);
}
