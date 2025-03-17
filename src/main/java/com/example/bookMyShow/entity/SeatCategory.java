package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SeatCategory")
public class SeatCategory {

    @Id
    private String id;
    private int price;

    public String getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SeatCategory(int price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
}