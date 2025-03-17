package com.example.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "Booking")
public class Booking {
    @Id
    private String id;
    private String paymentId;
    private String showId;
    private BookingStatus status;

    public Booking(String paymentId, String showId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.showId = showId;
        book(paymentStatus);
    }

    private void book(PaymentStatus paymentStatus) {
        if (paymentStatus == PaymentStatus.SUCCESS) {
            this.status = BookingStatus.CONFIRMED;
        } else {
            this.status = BookingStatus.PENDING;
        }
    }


}
