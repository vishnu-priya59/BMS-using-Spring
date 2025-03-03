package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Booking")
public class Booking {
    @Id
    private String id; //pk
    private String paymentId; // fk -> paymentTable
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

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public String getId() {
        return id;
    }

    public BookingStatus getStatus() {
        return status;
    }


}
