package com.movie_app.booking_service.discounts;

import org.springframework.stereotype.Component;

import com.movie_app.booking_service.entity.Show;



@Component
public class ThirdTicketDiscount implements DiscountStrategy {

    @Override
    public double apply(double total, int count, Show show) {
        if (count >= 3) {
            return total - (show.getPrice() * 0.5);
        }
        return total;
    }
}