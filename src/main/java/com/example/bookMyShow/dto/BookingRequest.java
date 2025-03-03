package com.example.bookMyShow.dto;

import com.example.bookMyShow.entity.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class BookingRequest {
    private String payId;
    private String showId;
    private PaymentStatus paymentStatus;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
