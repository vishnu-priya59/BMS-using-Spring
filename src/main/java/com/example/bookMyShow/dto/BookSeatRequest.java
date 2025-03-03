package com.example.bookMyShow.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookSeatRequest {
    private String showId;
    private List<Integer> seatNumbers;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}
