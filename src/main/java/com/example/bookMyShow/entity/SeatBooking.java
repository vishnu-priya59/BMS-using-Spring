package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SeatBooking")
public class SeatBooking {

    @Id
    private String id;
    private String seatId;
    private String bookingId;

    public void setId(String id) {
        this.id = id;
    }

    public SeatBooking(String seatId, String bookingId) {
        this.seatId = seatId;
        this.bookingId = bookingId;
    }

    public String getId() {
        return id;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getSeatId() {
        return seatId;
    }
}
