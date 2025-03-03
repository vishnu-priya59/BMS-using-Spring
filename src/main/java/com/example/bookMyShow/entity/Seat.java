package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Seat")
public class Seat {

    @Id
    private String id;
    private String screenId;
    private int seatNumber;

    public Seat(String screenId, int seatNumber) {
        this.screenId = screenId;
        this.seatNumber = seatNumber;
    }
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

}
