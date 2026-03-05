package com.movie_app.booking_service.discounts;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.movie_app.booking_service.entity.Show;



@Component
public class AfternoonDiscount implements DiscountStrategy {

    @Override
    public double apply(double total, int count, Show show) {
        if (show.getShowTime().isAfter(LocalTime.NOON)
                && show.getShowTime().isBefore(LocalTime.of(16, 0))) {
            return total * 0.8;
        }
        return total;
    }
}
