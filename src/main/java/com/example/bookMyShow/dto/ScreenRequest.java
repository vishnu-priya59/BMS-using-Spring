package com.example.bookMyShow.dto;

import org.springframework.stereotype.Component;

@Component
public class ScreenRequest {
    private String theatreId;
    private String name;
    private int totalSeats;

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}
