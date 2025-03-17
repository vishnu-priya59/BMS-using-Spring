package com.example.bookMyShow.dto;

import com.example.bookMyShow.entity.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class BookingRequest {
    private String payId;
    private String showId;
    private PaymentStatus paymentStatus;

}
