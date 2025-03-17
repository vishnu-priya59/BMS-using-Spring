package com.example.bookMyShow.entity;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Screen")
public class Screen {

    @Id
    private String Id;
    @Setter
    private String theatreId;
    @Setter
    private String screenName;
    @Setter
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

    public void setId(String id) {
        this.Id = id;
    }


    public String getId() {
        return Id;

    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
