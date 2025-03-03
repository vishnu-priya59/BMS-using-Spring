package com.example.bookMyShow.entity;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Screen")
public class Screen {

    @Id
    private String id;
    @Setter
    private String theatreId;
    private String screenName;
    private int totalSeats;

    public Screen(String theatreId, String screenName, int totalSeats) {
        this.theatreId = theatreId;
        this.screenName = screenName;
        this.totalSeats = totalSeats;
    }

    public String getName() {
        return screenName;
    }

    public void setName(String name) {
        this.screenName = name;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }


}
